$(document).ready(function(){

  $('table #edit-button').on('click', function(event){
    event.preventDefault();

    let href = $(this).attr('href')

      $.get(href, function(location, status){
      $('#edit-id').val(location.id);
      $('#edit-address').val(location.address);
      $('#edit-city').val(location.city);
      $('#edit-description').val(location.description);
      $('#edit-details').val(location.details);
    });
    $('#editModal').modal('toggle');
  });

  // $('.table #details-button').on('click',function(event) {
  //   event.preventDefault();
  //
  //   let href= $(this).attr('href');
  //
  //   $.get(href, function(project, status){
  //
  //     $('#details-id').val(project.id);
  //     $('#details-name').val(project.name);
  //     $('#details-description').val(project.description);
  //     $('#details-course').val(project.course);
  //     $('#details-educator').val(project.educator);
  //     $('#details-owner').val(project.owner);
  //     $('#details-education-time').val(project.educationTime);
  //     $('#details-planning-time').val(project.planningTime);
  //     $('#details-start-date').val(project.startDate);
  //     $('#details-end-date').val(project.endDate);
  //     $('#details-location').val(project.locationId);
  //     // $('#overdue').val(project.overdue);
  //     $('#lastModifiedByDetails').val(project.lastModifiedBy);
  //     $('#lastModifiedDateDetails').val(project.lastModifiedDate.substr(0,19).replace("T", " "));
  //   });
  //   $('#detailsModal').modal();
  // });

  $('table #delete-button').on('click', function(event){
    event.preventDefault();

    let href = $(this).attr('href')

    $('#delete-location-button').attr('href', href)

    $('#deleteModal').modal('toggle');

  });

});
