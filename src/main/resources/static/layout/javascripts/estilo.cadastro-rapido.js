$(function (){
    var modal = $('#modalCadastroRapidoEstilo');
    var botaoSalvar = modal.find('.js-modal-cadastro-estilo-salvar-btn');
    var form = modal.find('form');
    form.on('submit', function (event){event.preventDefault()});
    var url = form.attr('action');
    var inputNomeEstilo = $('#nomeEstilo');
    var containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo');

    botaoSalvar.on('click',onBotaoSalvarClick);

    function onBotaoSalvarClick(){
        var nomeEstilo = inputNomeEstilo.val().trim();
        $.ajax({
            url:url,
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({nome: nomeEstilo}),
            error: onErrorSalvandoEstilo,
            success: onEstiloSalvo
        })
    }

    function onErrorSalvandoEstilo(obj){
        var mensagemErro = obj.responseText;
        containerMensagemErro.removeClass('hidden');
        containerMensagemErro.html('<span'+mensagemErro+'</span>');
        form.find('.form-group').addClass('has-error');
    }

    function onEstiloSalvo(estilo){
        var comboEstilo = $('#comboEstilo');
        comboEstilo.append('<option value='+ estilo.codigo + '>' + estilo.nome + '</option>');
        comboEstilo.val(estilo.codigo);
        modal.hide('hide');
    }

})