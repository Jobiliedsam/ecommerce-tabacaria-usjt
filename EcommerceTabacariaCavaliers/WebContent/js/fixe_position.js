// Verifica se é mobile 
let isMobile = Boolean(document.body.scrollWidth < 600);

let checkScroll = true;

let aside = document.querySelector('#aside-fixed');
let scroll = aside.getBoundingClientRect().y;

// Executa apenas uma vez a cada 150ms
function verifyScroll() {
    if(checkScroll && !isMobile) {
        checkScroll = false;
        changePosition();
    }
    else setTimeout(checkScroll = true, 150);
}

function changePosition() {
    if(window.pageYOffset >= scroll) {
        aside.style.position = 'fixed';
    }    
    else {
        aside.style.position = 'relative';
    }
}

window.addEventListener('scroll', verifyScroll);

