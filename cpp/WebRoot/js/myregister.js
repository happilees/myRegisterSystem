function sendForm() {
var fd = new FormData(document.getElementById("fileinfo"));
var name = $("input#name").val();
var classname = $("input#classname").val();
var phone = $("input#phone").val();
var introduce = $("textarea#introduce").val();
var power=$("textarea#power").val();
fd.append("name",name);
fd.append("classname",classname);
fd.append("phone",phone);
fd.append("introduce",introduce);
fd.append("power",power);
//data.append("file", myBlob);
$.ajax({
  url: "student_register.action",
  type: "POST",
  data: fd,
  processData: false,  // 告诉jQuery不要去处理发送的数据
  contentType: false,  // 告诉jQuery不要去设置Content-Type请求头
  success: function() {
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
  error: function() {
      // Fail message
      $('#success').html("<div class='alert alert-danger'>");
      $('#success > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
          .append("</button>");
      $('#success > .alert-danger').append("<strong>Sorry " + firstName + ", 服务器没响应，请稍后再试!");
      $('#success > .alert-danger').append('</div>');
      //clear all fields
      $('#contactForm').trigger("reset");
  },
})};