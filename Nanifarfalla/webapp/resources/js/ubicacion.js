$(document).ready(function(){

$('.myForm14 #comboboxPais').on('change', function(){

    var codigo_pais= $('.myForm14 select#comboboxPais option:selected').val();
        alert(codigo_pais);
        $.getJSON({         

             ajax : 'true',

            url:'../usuarios/cargarPais/' + codigo_pais,            
           

            success: function(data,statusText){             
            	 var data = $.parseJSON(data);
                 

                var html= '<option value="">Seleccione Provincia</option>';  


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