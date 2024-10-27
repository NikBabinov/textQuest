const checkboxViewPassword = document.getElementById('login__password-show');
checkboxViewPassword.addEventListener("change", viewPassword);

function viewPassword() {
    const password = document.getElementById('login__password');
    if (password.type === 'password') {
        password.type = 'text';
    } else {
        password.type = 'password';
    }
}