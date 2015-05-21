function resetForm(){for(var e=document.getElementsByClassName("error"),t=0;t<e.length;t++)e[t].classList.remove("visible")}function validateEmail(e){var t=new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);return t.test(e)}function validateLogin(e,t){for(var n,r=0;r<t.length;r++)if(""===t[r].element.value||/\S/.test(t[r].element.value)===!1){var a=document.getElementById(t[r].key+"Error");a.classList.add("visible"),a.innerHTML="<i class='fa fa-exclamation-triangle'></i> Required",n=!0}n===!0&&e.preventDefault()}function validateRegister(e,t){for(var n,r=0;r<t.length;r++)if(""===t[r].element.value||/\S/.test(t[r].element.value)===!1){var a=document.getElementById(t[r].key+"Error");a.classList.add("visible"),a.innerHTML="<i class='fa fa-exclamation-triangle'></i> Required",n=!0}else{if("email"===t[r].element.id&&validateEmail(t[r].element.value)===!1){var i=document.getElementById(t[r].key+"Error");i.classList.add("visible"),i.innerHTML="<i class='fa fa-exclamation-triangle'></i> Invalid",n=!0}if("passwordVerification"===t[r].element.id&&t[r].element.value!==t[r-1].element.value){var l=document.getElementById(t[r].key+"Error");l.classList.add("visible"),l.innerHTML="<i class='fa fa-exclamation-triangle'></i> Mismatch",n=!0}}n===!0&&e.preventDefault()}function validateComment(e,t){for(var n,r=0;r<t.length;r++)if(""===t[r].element.value||/\S/.test(t[r].element.value)===!1){var a=document.getElementById(t[r].key+"Error");a.classList.add("visible"),a.innerHTML="<i class='fa fa-exclamation-triangle'></i> Required",n=!0}n===!0&&e.preventDefault()}function removeError(){(""!==this.value||/\S/.test(this.value)===!0)&&document.getElementById(this.id+"Error").classList.remove("visible")}function loginListeners(e){var t=document.getElementById("submit"),n=[{key:"userName",element:document.getElementById("userName")},{key:"password",element:document.getElementById("password")}];if(e.addEventListener){t.addEventListener("click",function(e){validateLogin(e,n)},!1);for(var r=0;r<n.length;r++)n[r].element.addEventListener("keyup",removeError,!1);e.addEventListener("reset",resetForm,!1)}else if(e.attacheEvent){t.attachEvent("click",function(e){validateLogin(e,n)});for(var r=0;r<n.length;r++)n[r].element.addEventListener("keyup",removeError);e.addEventListener("reset",resetForm)}}function commentListeners(e){var t=document.getElementById("submit"),n=[{key:"title",element:document.getElementById("title")},{key:"comment",element:document.getElementById("comment")}];if(e.addEventListener){t.addEventListener("click",function(e){validateComment(e,n)},!1);for(var r=0;r<n.length;r++)n[r].element.addEventListener("keyup",removeError,!1);e.addEventListener("reset",resetForm,!1)}else if(e.attacheEvent){t.attachEvent("click",function(e){validateComment(e,n)});for(var r=0;r<n.length;r++)n[r].element.addEventListener("keyup",removeError);e.addEventListener("reset",resetForm)}}function registrationListeners(e){var t=document.getElementById("submit"),n=[{key:"firstName",element:document.getElementById("firstName")},{key:"lastName",element:document.getElementById("lastName")},{key:"userName",element:document.getElementById("userName")},{key:"email",element:document.getElementById("email")},{key:"password",element:document.getElementById("password")},{key:"passwordVerification",element:document.getElementById("passwordVerification")}];if(e.addEventListener){t.addEventListener("click",function(e){validateRegister(e,n)},!1);for(var r=0;r<n.length;r++)n[r].element.addEventListener("keyup",removeError,!1);e.addEventListener("reset",resetForm,!1)}else if(e.attacheEvent){t.attachEvent("click",function(e){validateRegister(e,n)});for(var r=0;r<n.length;r++)n[r].element.addEventListener("keyup",removeError);e.addEventListener("reset",resetForm)}}function init(){var e=document.getElementById("commentForm");e&&commentListeners(e);var t=document.getElementById("registerForm");t&&registrationListeners(t);var n=document.getElementById("loginForm");n&&loginListeners(n)}