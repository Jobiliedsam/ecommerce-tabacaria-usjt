// Globais

// Verifica se é mobile 
let isMobile = Boolean(document.body.scrollWidth < 600)

let myBannerSlider = document.querySelectorAll('.myBannerSlider').forEach( banner => {
    let dataHeight = banner.getAttribute('data-height')
    let childrens = banner.querySelectorAll('.mbs-item')

    if(banner.getAttribute('data-play') == null) banner.setAttribute('data-play', 'yes')

    if(banner.getAttribute('data-play') == 'yes' && banner.getAttribute('data-timeplay') == null) {
        banner.setAttribute('data-timeplay', '5')
    }

    banner.setAttribute('data-pos', '0')
    banner.style.maxHeight = `${dataHeight}px` 

    childrens.forEach( child => {
        let imgBg = child.querySelector('.mbs-bg')

        child.style.background = `rgba(0, 0, 0, 0) url(${imgBg.getAttribute('src')}) no-repeat center`   

        if(!isMobile) {
            banner.style.height = `${dataHeight}px`
            child.style.height = `${dataHeight}px`
        } 
        else {
            banner.style.height = `${imgBg.scrollHeight}px`
            child.style.height = `${imgBg.scrollHeight}px`
        }

        imgBg.remove(child) 

    })

    if(childrens.length > 1) MyBannerNavWappers(banner, childrens)
})

// Adiciona captions
function MyBannerNavWappers(banner, childrens) {
    let captions = []
    let wappers = document.createElement('div')

    wappers.setAttribute('class', 'mbs-nav')
    banner.appendChild(wappers)

    for(let i = 0; i < childrens.length; i++) {
        let items = document.createElement('span')
        items.setAttribute('data-pos', `${i}`)
        wappers.appendChild(items)

        captions.push(items)
    }

    if(!isMobile) MyBannerNavControles(banner, childrens, captions)
    SetMyBanner(banner, childrens, captions, 0, 1)
    MyBannerCaptionListeners(banner, childrens, captions)
    MyBannerTouchSlider(banner, childrens, captions)
}

// Adicion Controles
function MyBannerNavControles(banner, childs, capts) {
    let left = document.createElement('div')
    let right = document.createElement('div')

    left.setAttribute('class', 'mbs-left-arrow')
    right.setAttribute('class', 'mbs-right-arrow')

    left.innerHTML = '‹'
    right.innerHTML = '›'

    banner.appendChild(left)
    banner.appendChild(right)

    left.style.marginTop = `-${left.scrollHeight / 2}px`
    right.style.marginTop = `-${right.scrollHeight / 2}px`  

    // Previnir seleção, nas setas
    left.addEventListener('selectstart', (event) => {event.preventDefault()})
    right.addEventListener('selectstart', (event) => {event.preventDefault()})
    
    left.addEventListener('click', () => MyBannerLeft(banner, childs, capts))
    right.addEventListener('click', () => MyBannerRight(banner, childs, capts))
}

// Definir banner
function SetMyBanner(banner, child, caption, index, old) { 
    if(!banner.isChanging) {
        clearTimeout(banner.bannerAutoPlay)

        // Define auto play
        if(banner.getAttribute('data-play') == 'yes') {
            banner.bannerAutoPlay =  setTimeout(() => {
                return MyBannerRight(banner, child, caption)
                }, Number(banner.getAttribute('data-timeplay')) * 1000)
        }

        // Define que esta em transição
        banner.isChanging = true
        banner.setAttribute('data-pos', `${index}`)
        child[old].style.zIndex = '0'
        child[old].removeAttribute('rel')
        caption[old].removeAttribute('class')

        child[index].setAttribute('rel', 'active-banner')
        child[index].style.zIndex = 1
        caption[index].setAttribute('class', 'active')

        setTimeout(() => {
            banner.isChanging = false
            return banner.bannerAutoPlay    
        }, 500)
    }
}

// Adicionar Listeners
function MyBannerCaptionListeners(banner, childrens, captions) {
    for(let i = 0; i < captions.length; i++) {
        captions[i].addEventListener('click', () => {
            let pos = Number(banner.getAttribute('data-pos'))
            if(pos != i) SetMyBanner(banner, childrens, captions, i, pos)
        })
    }
}

function MyBannerLeft(banner, childrens, captions) {
    let pos = Number(banner.getAttribute('data-pos'))
    if(pos > 0) SetMyBanner(banner, childrens, captions, (pos - 1), pos)
    if(pos == 0) SetMyBanner(banner, childrens, captions, (captions.length - 1), pos)
}

function MyBannerRight(banner, childrens, captions) {
    let pos = Number(banner.getAttribute('data-pos'))
    if(pos < captions.length - 1) SetMyBanner(banner, childrens, captions, (pos + 1), pos)    
    if(pos == captions.length - 1) SetMyBanner(banner, childrens, captions, 0, pos)
}

// Mouse Slider
function MyBannerTouchSlider(banner, child, caption) {
    let startX
    let disX

    if(!isMobile) {
        banner.addEventListener('mousedown', e => {
            startX = e.pageX // Define local do click no eixo X
        })
        banner.addEventListener('mouseup',  e => {
            disX = startX - e.pageX // Define distancia wue o click se arrasta
            if(disX < -100) MyBannerRight(banner, child, caption)
            if(disX > 100) MyBannerLeft(banner, child, caption)      
        })
    }
    else {
        banner.addEventListener('touchstart', e => {
            startX = e.changedTouches[0].pageX // Define local do click no eixo X            
        })
        banner.addEventListener('touchend',  e => {
            disX = startX - e.changedTouches[0].pageX
            if(disX < -100) MyBannerRight(banner, child, caption)
            if(disX > 100) MyBannerLeft(banner, child, caption)   
        })
    }    
}
