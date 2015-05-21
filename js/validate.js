/* jshint shadow:true */
function resetForm() {
    var errors = document.getElementsByClassName( 'error' );

    for ( var i = 0; i < errors.length; i++ ) {
        errors[i].classList.remove('visible');
    }
} // end resetFormErrors

function validateEmail( email ) {
    var pattern = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
    return pattern.test(email);
} // end validateEmail

function validateLogin( event, fields ) {
    var error;
    // check all values to see if blank
    for ( var i = 0; i < fields.length; i++ ) {
        // check that input is present
        if( fields[i].element.value === "" || /\S/.test( fields[i].element.value ) === false ) {
            var reqError = document.getElementById( fields[i].key + 'Error' );
            reqError.classList.add('visible');
            reqError.innerHTML = "<i class='fa fa-exclamation-triangle'></i> Required";
            error = true;
        }
    }
    // prevent default if error is present
    if ( error === true ) {
        event.preventDefault();
    }
} // end validate comment

function validateRegister( event, fields ) {
    var error;
    // check all values to see if blank
    for ( var i = 0; i < fields.length; i++ ) {
        // check that input is present
        if( fields[i].element.value === "" || /\S/.test( fields[i].element.value ) === false ) {
            var reqError = document.getElementById( fields[i].key + 'Error' );
            reqError.classList.add('visible');
            reqError.innerHTML = "<i class='fa fa-exclamation-triangle'></i> Required";
            error = true;
        } else {
            // if input is present, validate email address
            if ( fields[i].element.id === 'email' && validateEmail( fields[i].element.value ) === false) {
                var emailError = document.getElementById( fields[i].key + 'Error' );
                emailError.classList.add('visible');
                emailError.innerHTML = "<i class='fa fa-exclamation-triangle'></i> Invalid";
                error = true;
            }
            // if input is present, validate passwords match
            if ( fields[i].element.id === 'passwordVerification' && fields[i].element.value !== fields[i-1].element.value ) {
                var verError = document.getElementById( fields[i].key + 'Error' );
                verError.classList.add('visible');
                verError.innerHTML = "<i class='fa fa-exclamation-triangle'></i> Mismatch";
                error = true;
            }
        } // end else block
    }
    // prevent default if error is present
    if ( error === true ) {
        event.preventDefault();
    }
} // end validate Register

function validateComment( event, fields ) {
    var error;
    // check all values to see if blank
    for ( var i = 0; i < fields.length; i++ ) {
        // check that input is present
        if( fields[i].element.value === "" || /\S/.test( fields[i].element.value ) === false ) {
            var reqError = document.getElementById( fields[i].key + 'Error' );
            reqError.classList.add('visible');
            reqError.innerHTML = "<i class='fa fa-exclamation-triangle'></i> Required";
            error = true;
        }
    }
    // prevent default if error is present
    if ( error === true ) {
        event.preventDefault();
    }
} // end validate comment

function removeError() {
    // console.log( this.id );
    if( this.value !== "" || /\S/.test( this.value ) === true ) {
        document.getElementById( this.id + 'Error' ).classList.remove('visible');
    }
} // end removeRegisterErrors

function loginListeners( form ) {

    var submit = document.getElementById( 'submit' );
    var fields = [
       { key: "userName", element: document.getElementById( 'userName' ) },
       { key: "password", element: document.getElementById( 'password' ) },
    ];
    if ( form.addEventListener ) {
        // submission validation
        submit.addEventListener('click', function( e ) {
            validateLogin( e, fields );
        }, false);
        // add listeners to each element for clearing errors on keyup
        for ( var i = 0; i < fields.length; i++ ) {
            fields[i].element.addEventListener( 'keyup', removeError, false);
        }
        // add reset event listner
        form.addEventListener( 'reset', resetForm, false );
    }
    // Legacy MS support
    else if ( form.attacheEvent ) {
        // submission validation
        submit.attachEvent('click', function( e ) {
            validateLogin( e, fields );
        });
        // add listeners to each element for clearing errors on keyup
        for ( var i = 0; i < fields.length; i++ ) {
            fields[i].element.addEventListener( 'keyup', removeError);
        }
        // add reset event listner
        form.addEventListener( 'reset', resetForm);
    }
} // end addEntryListeners

function commentListeners( form ) {

    var submit = document.getElementById( 'submit' );
    var fields = [
       { key: "title", element: document.getElementById( 'title' ) },
       { key: "comment", element: document.getElementById( 'comment' ) },
    ];
    if ( form.addEventListener ) {
        // submission validation
        submit.addEventListener('click', function( e ) {
            validateComment( e, fields );
        }, false);
        // add listeners to each element for clearing errors on keyup
        for ( var i = 0; i < fields.length; i++ ) {
            fields[i].element.addEventListener( 'keyup', removeError, false);
        }
        // add reset event listner
        form.addEventListener( 'reset', resetForm, false );
    }
    // Legacy MS support
    else if ( form.attacheEvent ) {
        // submission validation
        submit.attachEvent('click', function( e ) {
            validateComment( e, fields );
        });
        // add listeners to each element for clearing errors on keyup
        for ( var i = 0; i < fields.length; i++ ) {
            fields[i].element.addEventListener( 'keyup', removeError);
        }
        // add reset event listner
        form.addEventListener( 'reset', resetForm);
    }
} // end addEntryListeners

function registrationListeners( form ) {
    var submit = document.getElementById( 'submit' );
    var fields = [
       { key: "firstName", element: document.getElementById( 'firstName' ) },
       { key: "lastName", element: document.getElementById( 'lastName' ) },
       { key: "userName", element: document.getElementById( 'userName' ) },
       { key: "email", element: document.getElementById( 'email' ) },
       { key: "password", element: document.getElementById( 'password' ) },
       { key: "passwordVerification", element: document.getElementById( 'passwordVerification' ) }
    ];
    if ( form.addEventListener ) {
        // submission validation
        submit.addEventListener('click', function( e ) {
            validateRegister( e, fields );
        }, false);

        // add listeners to each element for clearing errors on keyup
        for ( var i = 0; i < fields.length; i++ ) {
            fields[i].element.addEventListener( 'keyup', removeError, false);
        }
        // add reset event listner
        form.addEventListener( 'reset', resetForm, false );
    }
    // for legacy MS support
    else if (form.attacheEvent) {
        // submission validation
        submit.attachEvent('click', function( e ) {
            validateRegister( e, fields );
        });
        // add listeners to each element for clearing errors on keyup
        for ( var i = 0; i < fields.length; i++ ) {
            fields[i].element.addEventListener( 'keyup', removeError);
        }
        // add reset event listner
        form.addEventListener( 'reset', resetForm);
    }
} // end registration listeners

function init() {
    // Check for comment form, and add event listeners if present
    var commentForm = document.getElementById( 'commentForm' );
    if ( commentForm ) {
        commentListeners( commentForm );
    }
    // Check for new user registration form, and add event listeners if present
    var registerForm = document.getElementById( 'registerForm' );
    if ( registerForm ) {
        registrationListeners( registerForm );
    }

    // Check for login form, and add event listeners if present
    var loginForm = document.getElementById( 'loginForm' );
    if ( loginForm ) {
        loginListeners( loginForm );
    }
} // end init

