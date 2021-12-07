$(document).ready(function(){

  $('table #edit-button').on('click', function(event){
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function(contact, status){
      $('#edit-id').val(contact.id);
      $('#edit-firstname').val(contact.firstname);
      $('#edit-lastname').val(contact.lastname);
      $('#edit-email').val(contact.email);
      $('#edit-phone').val(contact.phone);
      $('#edit-mobile').val(contact.mobile);
      $('#edit-remarks').val(contact.remarks);
    });
    $('#editModal').modal('toggle');
  });

  // $('.table #details-button').on('click',function(event) {
  //   event.preventDefault();
  //
  //   let href= $(this).attr('href');
  //
  //   $.get(href, function(contact, status){
  //
  //     $('#details-id').val(contact.id);
  //     $('#details-name').val(contact.name);
  //     $('#details-description').val(contact.description);
  //     $('#details-course').val(contact.course);
  //     $('#details-educator').val(contact.educator);
  //     $('#details-owner').val(contact.owner);
  //     $('#details-education-time').val(contact.educationTime);
  //     $('#details-planning-time').val(contact.planningTime);
  //     $('#details-start-date').val(contact.startDate);
  //     $('#details-end-date').val(contact.endDate);
  //     $('#details-contact').val(contact.contactId);
  //     // $('#overdue').val(contact.overdue);
  //     $('#lastModifiedByDetails').val(contact.lastModifiedBy);
  //     $('#lastModifiedDateDetails').val(contact.lastModifiedDate.substr(0,19).replace("T", " "));
  //   });
  //   $('#detailsModal').modal();
  // });

  $('table #delete-button').on('click', function(event){
    event.preventDefault();

    let href = $(this).attr('href')

    $('#delete-contact-button').attr('href', href)

    $('#deleteModal').modal('toggle');

  });

});
