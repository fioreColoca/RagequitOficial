$('#followArticle').on('click', '#followUser', function(event) {​​
    event.preventDefault();
    const $form = $('#followUserForm');
    const data = $form.serialize();
    const url = $form.attr('action');
    const loading = Ladda.create(this);
    let followedUser = '';
    $.post(url, data, function(response) {​​
        loading.start();
        const data = JSON.parse(response);
        if (data.success) {​​
            const csrf = refreshFollowers($form, data);
            followedUser = data.fullName;
            $('#followArticle').append(`
                <form id="unfollowUserForm" action="/mua/${​​data.username}​​/unfollow" method="post" class="float-right">
                    <input type="hidden" name="_token" value="${​​csrf}​​">
                    <button id="unfollowUser" class="btn btn-default float-right dejar">SIGUIENDO</button>
                </form>      
            `);
        }
    }​​).done(function() {​​
        toastr.success(`¡Siguiendo a ${​​followedUser}​​!`);
    }​​).fail(function() {​
        toastr.error('No pudimos procesar el seguimiento. Intentalo más tarde.');
    }​​).always(function() {
        loading.stop();
    }​​);
}​​);

$('#followArticle').on('click', '#unfollowUser', function(event) {​​
    event.preventDefault();
    const $form = $('#unfollowUserForm');
    const data = $form.serialize();
    const url = $form.attr('action');
    const loading = Ladda.create(this);
    let followedUser = '';
    $.post(url, data, function(response) {​​
        loading.start();
        const data = JSON.parse(response);
        if (data.success) {​​
            const csrf = refreshFollowers($form, data);
            followedUser = data.fullName;
            $('#followArticle').append(`
                <form id="followUserForm" action="/mua/${​​data.username}​​/follow" method="post" class="float-right">
                    <input type="hidden" name="_token" value="${​​csrf}​​"> 
                    <button id="followUser" class="btn btn-violet float-right">SEGUIR</button> 
                </form>    
            `);
        }​​
    }​​).done(function() {​​
        toastr.success(`Dejaste de seguir a ${​​followedUser}​​`);
    }​​).fail(function() {​​
        toastr.error('No pudimos procesar tu pedido. Volvé a intentarlo');
    }​​).always(function() {​​
        loading.stop();
    }​​);
}​​);