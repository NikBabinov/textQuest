const horse = document.getElementById("horse");
const cell9 = document.getElementById("table__cell cell-9");
const cell10 = document.getElementById("table__cell cell-10");
const cell15 = document.getElementById("table__cell cell-15");
const saveObjectInBag = document.getElementById("get-save-object").getAttribute("data");
const maxNumbSaveObjectInBag = document.getElementById("get-max-numb-save-object").getAttribute("data");
const speechVasiliyNoHorse = document.getElementById("hero__text").getAttribute("data");
const speechVasiliySucessTakeHorse = document.getElementById("get-speech-from-server").getAttribute("data");
const heroSpeech = document.getElementById("hero__text");
const takePointerNoHorse = document.getElementById("get-speech-take-pointer-from-server").getAttribute("data");
const buttonBack = document.getElementById("button-back");

buttonBack.addEventListener("click", () => {
    location.href = "/question";
})

if (cell9) {
    cell9.addEventListener("click", exit);
}
if (cell10) {
    cell10.addEventListener("click", exit);
}
if (cell15) {
    cell15.addEventListener("click", exit);
}

if (horse) {
    horse.addEventListener("click", function () {
        let mas = saveObjectInBag.split(',');
        if (mas.length < maxNumbSaveObjectInBag) {
            heroSpeech.innerText = speechVasiliyNoHorse;
        } else {
            horse.parentNode.removeChild(horse);
            heroSpeech.innerText = speechVasiliySucessTakeHorse;
        }
    })
}

function exit() {
    if (heroSpeech.innerText === speechVasiliySucessTakeHorse) {
            location.href = "/lastPage"
    }else{
        heroSpeech.innerText = takePointerNoHorse;
    }
}