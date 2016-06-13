function sendForm() {  
     var formData = new FormData($( "#uploadForm" )[0]);  
     $.ajax({  
          url: 'student_register.action' ,  
          type: 'POST',  
          data: formData,  
          async: false,  
          cache: false,  
          contentType: false,  
          processData: false,  
          success: function (returndata) {  
        	// Success message
              $('#success').html("<div class='alert alert-success'>");
              $('#success > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                  .append("</button>");
              $('#success > .alert-success')
                  .append("<strong>恭喜你，已成功报名. </strong>");
              $('#success > .alert-success')
                  .append('</div>');

              //clear all fields
              $('#contactForm').trigger("reset");  
          },  
          error: function (returndata) {  
        	  // Fail message
              $('#success').html("<div class='alert alert-danger'>");
              $('#success > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                  .append("</button>");
              $('#success > .alert-danger').append("<strong>Sorry " + firstName + ", 服务器没响应，请稍后再试!");
              $('#success > .alert-danger').append('</div>');
              //clear all fields
              $('#contactForm').trigger("reset"); 
          }  
     });  
}  