async function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const res = await fetch("http://localhost:8080/authenticate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    });

    if (!res.ok) {
        document.getElementById("error").innerText = "Login failed";
        return;
    }

    const token = await res.text();
    localStorage.setItem("jwt", token);

    window.location.href = "index.html";
}

async function register() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    await fetch("http://localhost:8080/register/user", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username,
            password,
            role: "USER"
        })
    });

    alert("Registered! Now login.");
    window.location.href = "custom_login.html";
}