import {descifrar} from "./api.js";


const radioUnselect = document.getElementById("radioUnselect");
const radioMGF1 = document.getElementById("radioMGF1");
const radioPKCS = document.getElementById("radioPKCS");

const botonFormato = document.getElementById("botonFormato");
const botonDescifrar = document.getElementById("botonDescifrar");
const botonLimpiar = document.getElementById("botonLimpiar");

const txtTextoCifrado = document.getElementById("txtTextoCifrado");
const txtTextoDescifrado = document.getElementById("txtTextoDescifrado");

const txtClavePrivada = document.getElementById("txtClavePrivada");

let isTextCifradoJson = false;

botonFormato.addEventListener("click", () => {
    formatearJson(txtTextoCifrado);
});
botonLimpiar.addEventListener("click", onLimpiar);
botonDescifrar.addEventListener("click", ejecutarDescifrado);

radioUnselect.addEventListener("click", onClavePrivadaOff);
radioMGF1.addEventListener("click", onClavePrivadaOn);
radioPKCS.addEventListener("click", onClavePrivadaOn);


function onLimpiar() {
    txtTextoCifrado.value = "";
    txtTextoDescifrado.value = "";
}

function onClavePrivadaOn() {
    txtClavePrivada.disabled = false;
}

function onClavePrivadaOff() {
    txtClavePrivada.disabled = true;
}

function formatearJson(textArea) {
    try {
        const obj = JSON.parse(textArea.value);
        textArea.value = JSON.stringify(obj, null, 2);
        isTextCifradoJson = true;
    } catch (e) {
        alert("El texto no es un JSON válido");
        isTextCifradoJson = false;
    }
    return isTextCifradoJson;
}

function isJson(textArea) {
    try {
        const obj = JSON.parse(textArea.value);
        textArea.value = JSON.stringify(obj, null, 2);
        isTextCifradoJson = true;
    } catch (e) {
        isTextCifradoJson = false;
    }
}


async function ejecutarDescifrado() {
    try {
        isJson(txtTextoCifrado.value);
        const requestCifrado = {
            cadenaCifrada: txtTextoCifrado.value,
            formatoJson: isTextCifradoJson
        };
        txtTextoDescifrado.value = await descifrar(requestCifrado);

    } catch (e) {
        alert("Error al descifrar" + e);
    }
}
