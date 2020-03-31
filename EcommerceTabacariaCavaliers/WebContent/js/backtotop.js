backTop = document.querySelector('#back-to-top');

backTop.addEventListener('click', topFunction);
window.addEventListener('scroll', scrollFunction);

function scrollFunction() {
    if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
        backTop.style.display = "block";
    } 
    else {
        backTop.style.display = "none";
    }
}

function topFunction() {
    window.scrollTo({top: 0, behavior: 'smooth'});
} 

scrollFunction();