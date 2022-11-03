var main = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });
    },
    save : function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

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
    }
};
main.init();