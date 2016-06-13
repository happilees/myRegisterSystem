$(document).ready(function() {
    $('#defaultForm').bootstrapValidator({
        message: 'This value is not valid',
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	name: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                }
            },
            classname: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    regexp:{
                    	regexp:/^.*[\u4e00-\u9fa5].*$/,
                    	message:'专业简称+班'
                    }

                }
            },
              sex: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    }
                }
            },
             phone: {
                validators: {
                	notEmpty: {
                        message: '不能为空'
                    },
                    digits: {
                        message: '只能是数字'
                    },
                    regexp: {
                        regexp: /^([0-9]{11})?$/,
                        message: '必须为11为有效数字'
                    }
                }
            },
            introduce: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    }
                }
            },
            flag: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    }
                }
            },
        }
    }).on('error.form.bv', function(e) {
        console.log('error');

        // Active the panel element containing the first invalid element
        var $form         = $(e.target),
            validator     = $form.data('bootstrapValidator'),
            $invalidField = validator.getInvalidFields().eq(0),
            $collapse     = $invalidField.parents('.collapse');

        $collapse.collapse('show');
    });
});