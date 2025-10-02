// scripts.js - overlay, smooth scroll, accordion, contact honeypot, copy-to-clipboard, open/collapse all, stats anim, lazy video load
document.addEventListener('DOMContentLoaded', function(){

  // Overlay menu handlers
  const hamburger = document.getElementById('hamburger');
  const overlay = document.getElementById('overlayMenu');
  const closeOverlay = document.getElementById('closeOverlay');

  if(hamburger){
    hamburger.addEventListener('click', function(){
      if(overlay) { overlay.style.display = 'block'; overlay.setAttribute('aria-hidden','false'); }
    });
  }
  if(closeOverlay){
    closeOverlay.addEventListener('click', function(){
      if(overlay) { overlay.style.display = 'none'; overlay.setAttribute('aria-hidden','true'); }
    });
  }

  // close overlay on ESC
  document.addEventListener('keydown', function(e){
    if(e.key === 'Escape' && overlay && overlay.style.display === 'block'){
      overlay.style.display = 'none';
      overlay.setAttribute('aria-hidden','true');
    }
  });

  // Smooth scroll for internal links + update hash, close overlay if open
  document.querySelectorAll('a[href^="#"]').forEach(a => {
    a.addEventListener('click', function(e){
      const href = this.getAttribute('href');
      if(!href || href === '#') return;
      const id = href.slice(1);
      const target = document.getElementById(id);
      if(target){
        e.preventDefault();
        target.scrollIntoView({behavior:'smooth', block:'start'});
        // update hash without page jump
        history.replaceState(null, '', '#' + id);
        if(overlay) { overlay.style.display = 'none'; overlay.setAttribute('aria-hidden','true'); }
      }
    });
  });

  // Accordion: accessible panel behavior
  const accItems = document.querySelectorAll('.acc-item');
  accItems.forEach(item => {
    const head = item.querySelector('.acc-head');
    const body = item.querySelector('.acc-body');

    // set roles/attributes
    if(head){
      head.setAttribute('role', 'button');
      head.setAttribute('tabindex', '0');
    }

    // ensure closed by default unless already has .open (we keep first open by HTML default)
    if(!body.classList.contains('open')){
      body.style.display = 'none';
      body.classList.remove('open');
    } else {
      // ensure arrow rotated
      const arrow = item.querySelector('.acc-arrow');
      if(arrow) arrow.style.transform = 'rotate(90deg)';
    }

    // click handler
    if(head && body){
      head.addEventListener('click', function(){
        const isOpen = body.classList.contains('open');
        // close all
        document.querySelectorAll('.acc-body').forEach(b => {
          b.style.display = 'none';
          b.classList.remove('open');
          const parentHead = b.parentElement.querySelector('.acc-head .acc-arrow');
          if(parentHead) parentHead.style.transform = 'rotate(0deg)';
        });

        if(!isOpen){
          // open requested
          body.style.display = 'block';
          body.classList.add('open');
          const arrow = item.querySelector('.acc-arrow');
          if(arrow) arrow.style.transform = 'rotate(90deg)';

          // lazy-load any demo video inside this body
          const vid = body.querySelector('video.demo-video');
          if(vid && vid.dataset && vid.dataset.src) {
            if(!vid.getAttribute('data-loaded')) {
              const src = vid.dataset.src;
              const source = vid.querySelector('source');
              if(source && !source.src) source.src = src;
              vid.setAttribute('data-loaded','true');
              try { vid.load(); } catch(e){}
            }
          }
        }
      });

      // keyboard open
      head.addEventListener('keydown', function(e){
        if(e.key === 'Enter' || e.key === ' ') {
          e.preventDefault();
          head.click();
        }
      });
    }
  });

  // ensure first accordion item is open on load (unless user closed via collapse)
  (function openFirstIfNeeded(){
    const first = document.querySelector('.acc-item');
    if(!first) return;
    const firstBody = first.querySelector('.acc-body');
    if(firstBody && !firstBody.classList.contains('open')) {
      // open it (but only if it wasn't explicitly opened in HTML)
      firstBody.style.display = 'block';
      firstBody.classList.add('open');
      const arrow = first.querySelector('.acc-arrow');
      if(arrow) arrow.style.transform = 'rotate(90deg)';
    }
  })();

  // Open All / Collapse All
  const openAllBtn = document.getElementById('openAllBtn');
  const collapseAllBtn = document.getElementById('collapseAllBtn');
  if(openAllBtn) {
    openAllBtn.addEventListener('click', function(){
      document.querySelectorAll('.acc-item').forEach(item => {
        const body = item.querySelector('.acc-body');
        if(body){
          body.style.display = 'block';
          body.classList.add('open');
          const arrow = item.querySelector('.acc-arrow');
          if(arrow) arrow.style.transform = 'rotate(90deg)';
          // lazy load video if any
          const vid = body.querySelector('video.demo-video');
          if(vid && vid.dataset && vid.dataset.src && !vid.getAttribute('data-loaded')) {
            const source = vid.querySelector('source');
            if(source && !source.src) source.src = vid.dataset.src;
            vid.setAttribute('data-loaded','true');
            try { vid.load(); } catch(e){}
          }
        }
      });
    });
  }
  if(collapseAllBtn) {
    collapseAllBtn.addEventListener('click', function(){
      document.querySelectorAll('.acc-body').forEach(b => { b.style.display = 'none'; b.classList.remove('open'); });
      document.querySelectorAll('.acc-arrow').forEach(a => a.style.transform = 'rotate(0deg)');
    });
  }

  // Add copy buttons to all <pre><code> blocks (Prism is loaded separately)
  document.querySelectorAll('pre').forEach(pre => {
    // avoid adding twice
    if(pre.querySelector('.copy-btn')) return;
    const btn = document.createElement('button');
    btn.className = 'copy-btn';
    btn.type = 'button';
    btn.innerText = 'Copy';
    btn.addEventListener('click', async function(){
      const code = pre.querySelector('code');
      if(!code) return;
      const text = code.innerText;
      try {
        await navigator.clipboard.writeText(text);
        btn.innerText = 'Copied';
        setTimeout(()=> btn.innerText = 'Copy', 1400);
      } catch(e){
        // fallback: select + execCommand
        const range = document.createRange();
        range.selectNodeContents(code);
        const sel = window.getSelection();
        sel.removeAllRanges();
        sel.addRange(range);
        try {
          document.execCommand('copy');
          btn.innerText = 'Copied';
          setTimeout(()=> btn.innerText = 'Copy', 1400);
          sel.removeAllRanges();
        } catch(err){
          alert('Copy failed. Please select and copy manually.');
        }
      }
    });
    pre.style.position = 'relative';
    pre.appendChild(btn);
  });

  // Contact form basic handling (honeypot & basic validation)
  const form = document.getElementById('contactForm');
  if(form){
    form.addEventListener('submit', function(e){
      const honey = form.querySelector('input[name="company"]');
      if(honey && honey.value){
        e.preventDefault(); // suspected bot
        return;
      }
      const name = form.querySelector('input[name="name"]');
      const email = form.querySelector('input[name="email"]');
      const message = form.querySelector('textarea[name="message"]');
      if(!name.value || !email.value || !message.value){
        e.preventDefault();
        alert('Please fill Name, Email and Message.');
        return;
      }
      // UX: disable button
      const btn = form.querySelector('button[type="submit"]');
      if(btn){ btn.disabled = true; btn.textContent = 'Sending...'; }
      // using mailto: will open the mail client; if using Formspree change action accordingly
    });
  }

  // Animate numbers (generic)
  function animateNumber(el, target, duration=1200, suffix='') {
    if(!el) return;
    const start = 0;
    const startTime = performance.now();

    function update(now) {
      const progress = Math.min((now - startTime) / duration, 1);
      const value = Math.floor(start + (target - start) * progress);
      el.textContent = value + suffix;
      if(progress < 1) requestAnimationFrame(update);
    }
    requestAnimationFrame(update);
  }

  // Animate runtime seconds -> show mm m ss s
  function animateTime(el, targetSeconds=0, duration=1400) {
    if(!el) return;
    const start = 0;
    const startTime = performance.now();

    function format(sec){
      const m = Math.floor(sec / 60);
      const s = Math.floor(sec % 60);
      return `${m}m ${s}s`;
    }

    function update(now) {
      const progress = Math.min((now - startTime) / duration, 1);
      const value = Math.floor(start + (targetSeconds - start) * progress);
      el.textContent = format(value);
      if(progress < 1) requestAnimationFrame(update);
    }
    requestAnimationFrame(update);
  }

  // Start animations on load
  const testsEl = document.querySelector('.stat--tests .num');
  const passEl = document.querySelector('.stat--pass .num');
  const runtimeEl = document.querySelector('.stat--runtime .num');

  if(testsEl) {
    testsEl.textContent = '0';
    animateNumber(testsEl, 20, 1200, '');
  }
  if(passEl) {
    passEl.textContent = '0';
    animateNumber(passEl, 100, 1400, '%');
  }
  if(runtimeEl) {
    runtimeEl.textContent = '0';
    // target is 609 seconds (10m 9s)
    animateTime(runtimeEl, 609, 1400);
  }

  // --- Image modal (graphs) handling ---
  const imgModal = document.getElementById('imgModal');
  const imgModalImg = document.getElementById('imgModalImg');
  const imgModalCaption = document.getElementById('imgModalCaption');
  const imgModalClose = imgModal ? imgModal.querySelector('.img-modal-close') : null;

  function openImageModal(src, altText) {
    if(!imgModal) return;
    imgModalImg.src = src;
    imgModalImg.alt = altText || 'Enlarged graph';
    if(imgModalCaption) imgModalCaption.textContent = altText || '';
    imgModal.setAttribute('aria-hidden','false');
    try { imgModal.focus(); } catch(e){}
    document.body.style.overflow = 'hidden'; // prevent background scroll
  }

  function closeImageModal() {
    if(!imgModal) return;
    imgModal.setAttribute('aria-hidden','true');
    if(imgModalImg) imgModalImg.src = '';
    if(imgModalCaption) imgModalCaption.textContent = '';
    document.body.style.overflow = ''; // restore scroll
  }

  // open when clicking the image or the open button
  document.querySelectorAll('.graph-img, .open-graph').forEach(el => {
    el.addEventListener('click', function(e){
      const src = this.dataset && this.dataset.src ? this.dataset.src : this.getAttribute('src') || this.getAttribute('data-src') || (this.dataset && this.dataset.graph ? `images/${this.dataset.graph}.png` : null);
      const alt = this.alt || this.getAttribute('aria-label') || '';
      if(src) openImageModal(src, alt);
    });
  });

  // close handlers
  if(imgModalClose) imgModalClose.addEventListener('click', closeImageModal);
  if(imgModal){
    imgModal.addEventListener('click', function(e){
      if(e.target === imgModal) closeImageModal(); // click on backdrop closes
    });
    document.addEventListener('keydown', function(e){
      if(e.key === 'Escape' && imgModal && imgModal.getAttribute('aria-hidden') === 'false') closeImageModal();
    });
  }

  // small accessibility: enable Enter on nav pills in overlay
  document.querySelectorAll('.overlay-link').forEach(el => {
    el.setAttribute('tabindex','0');
  });

}); // end DOMContentLoaded

// Theme toggle + persist
(function(){
  const btn = document.getElementById('theme-toggle');
  if(!btn) return;

  // init from localStorage
  const stored = localStorage.getItem('site-theme');
  if(stored === 'dark') document.body.classList.add('dark-mode');

  // set icon initial
  btn.textContent = document.body.classList.contains('dark-mode') ? '☀️' : '🌙';

  btn.addEventListener('click', function(){
    const isDark = document.body.classList.toggle('dark-mode');
    btn.textContent = isDark ? '☀️' : '🌙';
    localStorage.setItem('site-theme', isDark ? 'dark' : 'light');
  });
})();
