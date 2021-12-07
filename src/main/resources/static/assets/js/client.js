$(document).ready(function(){

  $('table #edit-button').on('click', function(event){
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function(client, status){
      $('#edit-id').val(client.id);
      $('#edit-name').val(client.name);
      $('#edit-location').val(client.location);
      $('#edit-phone').val(client.phone);
      $('#edit-mobile').val(client.mobile);
      $('#edit-email').val(client.email);
      $('#edit-website').val(client.website);
      $('#edit-details').val(client.details);
    });
    $('#editModal').modal('toggle');
  });

  // $('.table #details-button').on('click',function(event) {
  //   event.preventDefault();
  //
  //   let href= $(this).attr('href');
  //
  //   $.get(href, function(client, status){
  //
  //     $('#details-id').val(client.id);
  //     $('#details-name').val(client.name);
  //     $('#details-description').val(client.description);
  //     $('#details-course').val(client.course);
  //     $('#details-educator').val(client.educator);
  //     $('#details-owner').val(client.owner);
  //     $('#details-education-time').val(client.educationTime);
  //     $('#details-planning-time').val(client.planningTime);
  //     $('#details-start-date').val(client.startDate);
  //     $('#details-end-date').val(client.endDate);
  //     $('#details-client').val(client.clientId);
  //     // $('#overdue').val(client.overdue);
  //     $('#lastModifiedByDetails').val(client.lastModifiedBy);
  //     $('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
  //   });
  //   $('#detailsModal').modal();
  // });

  $('table #delete-button').on('click', function(event){
    event.preventDefault();

    let href = $(this).attr('href')

    $('#delete-client-button').attr('href', href)

    $('#deleteModal').modal('toggle');

  });

});
