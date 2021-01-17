$(document).ready(function(){

$('.myForm14 #comboboxPais').on('change', function(){

    var idPais= $('.myForm14 select#comboboxPais option:selected').val();
        alert(idPais);
        $.getJSON({         

             ajax : 'true',

            url:'cargarPais/' + idPais ,            


            success: function(data,statusText){             

                 var data = $.parseJSON(data);

                var html= '<option value="">Seleccione Departamento</option>';  


                for(var i=0; i< data.length; i++){

                    html += '<option value="' + data[i].codigo_provincia + ' " >' +data[i].nombre_provincia + '</option>';
                }


                  alert(data);
                  html += '</option>';
                  $('.myForm14 select#comboboxDepartamento').html(html);


            },
             error: function(ob,errStr) {
                    alert('error');
                    console.log(ob,errStr);

                }
    });         

});
});