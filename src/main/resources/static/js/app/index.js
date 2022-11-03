var main = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });
        $('#btn-update').on('click', function() {
            _this.update();
        });
        $('#btn-delete').on('click', function() {
            _this.delete();
        });
    },
    save : function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        if ($('#title').val() === '') {
            alert('제목을 입력해 주세요.');
            $('#title').focus();
            return;
        } else if ($('#author').val() === '') {
            alert('작성자를 입력해 주세요.');
            $('#author').focus();
            return;
        } else if ($('#content').val() === '') {
            alert('내용을 작성해 주세요.');
            $('#content').focus();
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            console.log('됐나?');
            window.location.href = '/'; // 글 등록에 성공하면 메인페이지로 이동
        }).fail(function (error) {
            console.log('안됐나?');
            alert(JSON.stringify(error));
        });
    },
    update : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        if ($('#title').val() === '') {
            alert('제목을 입력해 주세요.');
            $('#title').focus();
            return;
        } else if ($('#content').val() === '') {
            alert('내용을 작성해 주세요.');
            $('#content').focus();
            return;
        }

        if (confirm("수정하시겠습니까?") == true) {
            $.ajax({
                        type: 'PUT',
                        url: '/api/v1/posts/' +id,
                        dataType: 'json',
                        contentType: 'application/json; charset=utf-8',
                        data: JSON.stringify(data)
                    }).done(function() {
                        alert('글이 수정되었습니다.');
                        window.location.href = '/';
                    }).fail(function(error) {
                        alert(JSON.stringify(error));
                    });
        } else {
        }


    },
    delete : function() {
        var id = $('#id').val();

        if (confirm("정말 삭제하시겠습니까?") == true) {
            $.ajax({
                        type: 'DELETE',
                        url: '/api/v1/posts/'+id,
                        dataType: 'json',
                        contentType: 'applicaton/json; charset=utf-8'
                    }).done(function() {
                        alert('글이 삭제되었습니다.');
                        window.location.href='/';
                    }).fail(function(error) {
                        alert(JSON.stringify(error));
                    });
        } else {

        }


    }
};
main.init();