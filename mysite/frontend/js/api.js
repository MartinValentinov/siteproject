async function loadProfile() {
    const token = localStorage.getItem("jwt");

    const res = await fetch("http://localhost:8080/api/me", {
        headers: {
            Authorization: "Bearer " + token
        }
    });

    const text = await res.text();
    document.getElementById("user").innerText = "Logged in as: " + text;
}