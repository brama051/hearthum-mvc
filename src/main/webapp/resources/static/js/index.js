$(document).ready(function() {
    //add new inventory item form - labels input becomes tagsInput plugin component
    $('input#labels[type=text][name=labels]').tagsInput({
        'defaultText': 'Add a label'
    });
});
