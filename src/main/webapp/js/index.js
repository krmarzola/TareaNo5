$(document).ready(function () {
    $("#datos").validate({
        rules: {
            datosIngresados: {
                required: true
            }
        }
    });
});