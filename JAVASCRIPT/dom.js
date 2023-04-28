fetch('https://api.rawg.io/api/games?key=9af72c943356453fb08b37b3f1f9a18a')
.then(response => response.json())
.then(data => {
    console.log(data.results)
    renderGames(data.results)
    renderCategories(data.results)
    renderPlatforms(data.results)
});

function renderGames(games)
{
    let row = document.querySelector('.row')
    row.classList.add('align-items-center')
    
    games.forEach(game => {
        let col = document.createElement('div')
        col.classList.add('col-12', 'col-md-3', 'my-3')
        let card = document.createElement('div')
        card.classList.add('card')
        card.innerHTML = `
        <img src="${game.background_image}" class="card-img-top" alt="...">
        <div class="card-body">
        <h5 class="card-title">${game.name}</h5>
        <p class="card-text">${game.released}</p>
        </div>`   
        row.appendChild(col)
        col.appendChild(card)  
    });
}

function renderCategories(games)
{ 
    let categories = Array.from(
        new Set(games.map(game => game.genres)
        .map(el => el.map(x => x.name))
        .flat())
        )
        let ul = document.querySelector('#categoriesList')
        categories.forEach(category => {
            let li = document.createElement('li')
            li.classList.add('nav-item')
            li.innerHTML = `<a href="#" class="nav-link text-decoration-none text-primary fw-bold" aria-current="page">
            <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
            ${category}
            </a>`
            
            ul.appendChild(li)
        })
        
        categories.forEach((category) => {
            let option = document.createElement('option')
            option.setAttribute("value", category)
            option.setAttribute("id", category)
            option.dataset.category = "category"
            option.innerHTML = `${category}`
            genresWrapper.appendChild(option)
        })
        
        let dataGenres = document.querySelectorAll('[data-genre]')
        dataGenres.forEach((option) => {
            option.addEventListener('click', () => {
                renderCategories(filterByCategory(games, option.id))
            })
        })
    }
     
    function filterByCategory(array, value) {
        return array.filter(el => {
            return el.genres.find(el => el.name == value)
        })
    }

    function renderPlatforms(games)
    {
        let platforms = Array.from(
            new Set(games.map(game => game.platforms)
            .map(el => el.map(el => el.platform.name)).flat()))

/*             platforms.forEach((platform) => {
                let option = document.createElement('option')
                option.setAttribute("value", platform)
                option.setAttribute("id", platform)
                option.dataset.platform = "platform"
                option.innerHTML = `${platform}`
                genresWrapper.appendChild(option)
            })
            
            let dataPlatforms = document.querySelectorAll('[data-genre]')
            dataPlatforms.forEach((option) => {
                option.addEventListener('click', () => {
                    renderCategories(filterByCategory(games, option.id))
                })
            })
     */
    }
    
    function filterByPlatforms(array, value) {
        return array.filter(el => {
            return el.platforms.find(el => el.name == value )
        })
    }

    
    
    