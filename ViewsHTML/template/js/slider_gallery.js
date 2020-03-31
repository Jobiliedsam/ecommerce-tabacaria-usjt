/**
 * Plugin criado por:
 * Paulo Cezario
 * https://github.com/ByakkoKa
 **/

let sgGalleries = document.querySelectorAll('.sliderGallery').forEach( gallery => {
    // Adiciona controladores
    gallery.innerHTML += `<div class="sg-left">‹</div>\n<div class="sg-right">›</div>`
    
    let sgData = {
        width: parseFloat(gallery.scrollWidth),
        height: Number(gallery.getAttribute('data-height')),
        show: Number(gallery.getAttribute('data-show')),
        spacing: parseFloat(gallery.getAttribute('data-spacing')),
        getChildWidth: false,
        childrenWidth: null,        
    }

    let container = gallery.querySelector('.sg-container')
    let childrens = container.querySelectorAll('.sg-item')
    let sgLeft = gallery.querySelector('.sg-left')
    let sgRight = gallery.querySelector('.sg-right')

    sgLeft.style.lineHeight = `${sgData['height'] - 30}px`
    sgRight.style.lineHeight = `${sgData['height'] - 30}px`

    childrens.forEach( e => {
        if(!sgData['getChildWidth']) {
            sgData['childrenWidth'] = (sgData['width'] / sgData['show']) + 
            (sgData['spacing'] / sgData['show']) - sgData['spacing']
            sgData['getChildWidth'] = true
        }
        e.style.height = `${sgData['height']}px`
        e.style.width = `${sgData['childrenWidth']}px`
        e.style.marginRight = `${sgData['spacing']}px`  
        e.addEventListener('selectstart', preventEvent)  
        e.addEventListener('dragstart', preventEvent) 
    })

    container.addEventListener('mousedown', () => {
        container.classList.add('sg-slider')
    })

    container.addEventListener('mouseup', () => {
        container.classList.remove('sg-slider')
    })

    // Adiciona Listeners
    sgLeft.addEventListener('click', () => {
        container.scrollLeft -= sgData['childrenWidth'] //+ sgData['spacing']
    })
    sgRight.addEventListener('click', () => {
        container.scrollLeft += sgData['childrenWidth'] //+ sgData['spacing']
    })

    sgMouseSlider(container)
    
})

// Mouse slider
function sgMouseSlider(element) {
    let isDown = false
    let startX 
    let scrollLeft

    element.addEventListener('mousedown', e => {
        isDown = true
        element.classList.add('sg-slider')
        startX = e.pageX - element.offsetLeft // Define local do click no eixo X
        scrollLeft = element.scrollLeft       // Define a local do scroll
    })
    element.addEventListener('mouseup',  () => {
        isDown = false
        element.classList.remove('sg-slider')
    })
    element.addEventListener('mousemove', e => {
        if(!isDown) return // Parar de executar se for false
        e.preventDefault()
        const x = e.pageX - element.offsetLeft // Define local onde click foi solto
        const walk = (x - startX)              // Distancia a percorer, aumentar a velocida com * N
        element.scrollLeft = scrollLeft - walk // Movimenta scroll do elemento
    })
}

// O método preventDefault foi colocado em um função para ser removido facilmente
function preventEvent(element){    
    element.preventDefault()
}