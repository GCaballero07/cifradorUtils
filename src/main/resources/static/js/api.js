export async function descifrar(requestCifrado) {
    const response = await fetch("/api/descifrar", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(requestCifrado)
    });

    if (!response.ok) {
        throw new Error("Error HTTP " + response.status);
    }

    return response.text();
}
