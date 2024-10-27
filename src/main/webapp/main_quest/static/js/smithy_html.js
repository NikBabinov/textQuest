let bag = [];
const horseshoe = document.getElementById('horseshoe');
const saddle = document.getElementById('saddle');
const cell6Exit = document.getElementById('table__cell cell-6');
const cell7Exit = document.getElementById('table__cell cell-7');
const cell11Exit = document.getElementById('table__cell cell-11');
const cell12Exit = document.getElementById('table__cell cell-12');

if (cell6Exit) {
    cell6Exit.addEventListener("click", exit);
}

if (cell7Exit) {
    cell7Exit.addEventListener("click", exit);
}

if (cell11Exit) {
    cell11Exit.addEventListener("click", exit);
}
if (cell12Exit) {
    cell12Exit.addEventListener("click", exit);
}

if (horseshoe) {
    horseshoe.addEventListener('click', function () {
        bag.push('horseshoe');
        horseshoe.parentNode.removeChild(horseshoe);
    })
}

if (saddle) {
    saddle.addEventListener("click", function () {
        bag.push('saddle');
        saddle.parentNode.removeChild(saddle);
    })
}


function exit() {
    sendServerBag();
}

function sendServerBag() {
    fetch('/smithy', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(bag),
    })
        .then(response => {
            if (response.ok) {
                location.href = '/question';
            }
        })
        .then(data => console.log(data))
        .catch(error => console.error('Error:', error));


}




