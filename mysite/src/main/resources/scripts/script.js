const button = document.getElementById('submit');

button.addEventListener('click', function() {
    event.preventDefault();

    const name = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const pass1 = document.getElementById('pass1').value;
    const pass2 = document.getElementById('pass2').value;

     document.getElementById("output").innerHTML =
        `<p>Name: ${name}</p>
         <p>Email: ${email}</p>
         <p>Password: ${pass1}</p>
         <p>Confirm Password: ${pass2}</p>`;
});