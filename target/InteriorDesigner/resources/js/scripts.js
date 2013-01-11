function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
function ajaxCheckIfAvailable(){var e=$("#user_email").val();var t=$.ajax({url:"user/check",data:{email:e},type:"POST",success:function(e){$("#helloDiv").html(e)}});t.done(function(t){$("#user_email").removeClass("emailExists").removeClass("emailAvailable");if(t=="alreadyExists"){$("#user_email").addClass("emailExists")}else if(t=="available"){if(validateEmail(e)){$("#user_email").addClass("emailAvailable")}else{$("#user_email").addClass("emailExists")}}else{console.log(t)}});t.fail(function(e,t){console.log("Request failed: "+t)})}

$('#homeSlider').carousel({
    interval: 2000
});

$(function() {
    $('#accordion').accordion();
});