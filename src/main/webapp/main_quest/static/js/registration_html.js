const emailRe = /^[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}$/i;
let bag = [];

const passwordItem = document.getElementById('user-registration__password');
const passwordRepeatItem = document.getElementById('user-registration__password-repeat');
const checkboxViewPassword = document.getElementById('user-registration__password-show');

document.getElementById('user-registration__email').addEventListener("change", emailChange);
passwordItem.addEventListener("change", passwordChange);
checkboxViewPassword.addEventListener("change", viewPassword);

function emailChange() {
    if (!emailRe.test(document.getElementById('user-registration__email').value)) {
        document.getElementById('email__label').innerHTML = "<span class='border_bottom-red'>проверьте email</span>";
    }

    if (emailRe.test(document.getElementById('user-registration__email').value)) {
        document.getElementById('email__label').innerHTML = "Введите email";
        document.getElementById('user-recovery__button').style.border = "1px solid orange";
    }

    if (document.getElementById('user-registration__email').value === "") {
        document.getElementById('email__label').innerHTML = "Введите email";
        document.getElementById('user-recovery__button').style.border = "1px solid orange";
    }
}

function redRepeatPassword() {
    document.getElementById('repeat-registration__paragraph').style.border = "2px solid red";
    document.getElementById('user-registration__password-repeat').style.borderBottom = "2px solid red";
    document.getElementById('user-registration__password-repeat').style.borderTop = "2px solid red";
}

function redPasswordParagraph() {
    document.getElementById('password-registration__paragraph').style.border = "2px solid red";
    document.getElementById('user-registration__password').style.borderBottom = "2px solid red";
    document.getElementById('user-registration__password').style.borderTop = "2px solid red";
}

function whitePasswordParagraph() {
    document.getElementById('password-registration__paragraph').style.border = "";
    document.getElementById('user-registration__password').style.borderBottom = "";
    document.getElementById('user-registration__password').style.borderTop = "";
}

function passwordChange() {
    if (document.getElementById('user-registration__password').value.length < 6) {
        document.getElementById('password__label').innerHTML = "Короткий пароль";
        redPasswordParagraph();
    }
    if (document.getElementById('user-registration__password').value.length >= 6) {
        document.getElementById('password__label').innerHTML = "Введите пароль";
        whitePasswordParagraph();
    }
    if (document.getElementById('user-registration__password').value.length === 0) {
        document.getElementById('password__label').innerHTML = "Введите пароль";
        whitePasswordParagraph();
    }
}

function viewPassword() {
    const password = document.getElementById('user-registration__password');
    const repeatPassword = document.getElementById('user-registration__password-repeat')
    if (password.type === 'password') {
        password.type = 'text';
        repeatPassword.type = 'text';
    } else {
        password.type = 'password';
        repeatPassword.type = 'password';
    }
}

function pressRegistrationButton() {
    const registrationButton = document.getElementById('user-registration__button');
    registrationButton.addEventListener('click', checkValueForm);
}

function pressRecoveryButton() {
    const recoveryButton = document.getElementById('user-recovery__button');
    recoveryButton.addEventListener('click', clickRecoveryButton);
}

function checkValueForm() {
    const valueFormMap = getRegistrationInput();
    let checkEmail = emailRe.test(document.getElementById('user-registration__email').value);
    let lenPassword = document.getElementById('user-registration__password').value.length;
    let passwordReCheck = (document.getElementById('user-registration__password').value === document.getElementById('user-registration__password-repeat').value);

    function sendServer(registrationInput){
        fetch('/registration', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(registrationInput),
        })
            .then(response => {
                if (response.ok) {
                    sucessRegistration();
                }
            })
            .then(data => console.log(data))
            .catch(error => console.error('Error:', error));


    }

    if (valueFormMap['emailBool'] === "" && checkEmail) {
        if (lenPassword >= 6) {
            if (passwordReCheck) {
                let email = document.getElementById('user-registration__email').value;
                let password = document.getElementById('user-registration__password').value;
                bag.push(email);
                bag.push(password);
                sendServer(bag);
            } else {
                document.getElementById('repeat-password__label').innerHTML = "Нет совпадения";
                redRepeatPassword();
                redPasswordParagraph();
            }
        } else {
            document.getElementById('password__label').innerHTML = "Короткий пароль";
            redPasswordParagraph();
        }
    } else {
        document.getElementById('user-registration__form').style.border = "2px solid red";
        document.getElementById('user-registration__legend').innerHTML = "Заполните все поля формы"
    }
}

function createButton() {
    const paragraph = document.getElementById('user-registration__paragraph-button');
    let div = document.createElement('input');
    div.setAttribute('type', 'button');
    div.setAttribute('class', 'user-registration__button');
    div.setAttribute('id', 'user-registration__button');
    div.setAttribute('value', 'зарегистрироваться');
    paragraph.appendChild(div);
    addRecoveryButton();
    safeEnter();
    pressRegistrationButton();
}

function addRecoveryButton() {
    const paragraph = document.getElementById('user-recovery__paragraph-button');
    let div = document.createElement('input');
    div.setAttribute('type', 'button');
    div.setAttribute('class', 'user-recovery__button');
    div.setAttribute('id', 'user-recovery__button');
    div.setAttribute('value', 'Восстановить пароль');
    paragraph.appendChild(div);
    pressRecoveryButton();
}

function safeEnter() {
    document.getElementById('user-registration__paragraph-l').style.display = "none";
}

function getRegistrationInput() {
    let emailBool = document.getElementById('user-registration__email-1').value;
    let email = document.getElementById('user-registration__email').value;
    let password = document.getElementById('user-registration__password').value;
    let passwordRepeat = document.getElementById('user-registration__password-repeat').value;

    return {
        emailBool: emailBool,
        email: email,
        password: password,
        passwordRepeat: passwordRepeat,
    };
}



function sucessRegistration() {
    innerForm = document.getElementById("user-registration");
    innerForm.innerHTML = "";
    let div = document.createElement('div');
    div.className = "user-registration__sucess";
    div.innerHTML = "Спасибо за регистрацию";
    innerForm.appendChild(div);
    setTimeout("document.location.href='/'", 2000);
}

function errorAddUser() {
    document.getElementById('email__label').innerHTML = "email занят";
    document.getElementById('mail-registration__paragraph').style.border = "2px solid red";
    document.getElementById('user-registration__email').style.borderBottom = "2px solid red";
    document.getElementById('user-registration__email').style.borderTop = "2px solid red";
    document.getElementById('user-recovery__button').style.border = "2px solid red";
}

function clickRecoveryButton() {
    document.location.href = '/recovery-user';
}

createButton();