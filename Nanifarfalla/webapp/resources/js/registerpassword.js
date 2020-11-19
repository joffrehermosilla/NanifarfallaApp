var password = [];
var password2 = [];


$(document).ready(function() {
    password = $('#password');
    password2 = $('#password-verify');

    var ruleValidator = function() {
        var pswd = $(this).val();
        //gets what is being input in the field and sets as variable
        
        if(pswd.length < 8) {
            $('#length').removeClass('valid').addClass('invalid');
        } else {
            $('#length').removeClass('invalid').addClass('valid');
            console.log('length '+ pswd.length);
        }

        // letter
        if(pswd.match(/[a-z]/) ) {
            $('#letter').removeClass('invalid').addClass('valid');
        } else {
            $('#letter').removeClass('valid').addClass('invalid');
        }

        // Capital
        if(pswd.match(/[A-Z]/)) {
            $('#capital').removeClass('invalid').addClass('valid');
        } else {
            $('#capital').removeClass('valid').addClass('invalid');

        }

        // number
        if ( pswd.match(/\d/) ) {
            $('#number').removeClass('invalid').addClass('valid');
        } else {
            $('#number').removeClass('valid').addClass('invalid');
        }

        // character
        if ( pswd.match(/[$&+,:;=?@#|'<>.^*()%!-]/) ) {
            $('#special').removeClass('invalid').addClass('valid');
            console.log('log: '+ pswd);
        } else {
            $('#special').removeClass('valid').addClass('invalid');
        }
    }

    password.focus(function() {
    // (triggers whenever the password field is selected by the user)
        $('.pswd_info').fadeIn('low');
    });
    password.blur(function() {
    // (triggers whenever the password field is unselected)
        $('.pswd_info').fadeOut('low');
    });
    $('.passwordButton').on('click', function(e) {
        e.preventDefault();
        if(password.val() !== password2.val()) {
            $('.incorrectMsg').show();
            password2.addClass('shake').addClass('invalidPass');
            password2.blur(function() {
            // (triggers whenever the password field is unselected)
                password2.trigger('reset');
                $('.incorrectMsg').hide();
                password2.removeClass('shake').removeClass('invalidPass');
            });
        } else {
            $('.incorrectMsg').hide();
        } 

    });
    $('.pswd_show').click(function (){
        console.log('click');
        password2.toggleClass('showPswd');

        if (password2.hasClass('showPswd')) {
            password2.attr('type', 'text');
            console.log("text");
            $('.pswd_show').html('Hide Password');
        } else{
            console.log("pswd");
            password2.attr('type', 'password');
            $('.pswd_show').html('Show Password');
        }
    });


    password.keyup(ruleValidator);
});