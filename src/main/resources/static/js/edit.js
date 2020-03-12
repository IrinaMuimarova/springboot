$('#editUser').on('show.bs.modal', function (event) {

    var button = $(event.relatedTarget); // Button that triggered the modal
    var id = button.data('id'); // Extract info from data-* attributes
     var login = button.data('login'); // Extract info from data-* attributes
     var name = button.data('name'); // Extract info from data-* attributes
     var password = button.data('password'); // Extract info from data-* attributes
    var modal = $(this);
        modal.find('#idEdit').val(id);
        modal.find('#name').val(name);
        modal.find('#login').val(login);
        modal.find('#password').val(password);
});