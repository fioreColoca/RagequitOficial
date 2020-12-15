<!-- Modal -->
<div class="modal fade" id="seguidoss" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header bg-dark">
                <h5 class="modal-title text-secondary" id="staticBackdropLabel">Seguidos</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body bg-dark">
                <c:if test="${not empty listaSeguidos }">
                    <c:forEach items="${listaSeguidos}" var="seguidos">
                        <div class="d-flex flex-start p-1">

                            <img src="${seguidos.getUrl_imagen()}" class=" rounded-circle img-seg">

                            <p class="text-secondary mt-auto ml-2">
                                <a class="nombreUsuarioPublicacion" href="perfil?usuarioNombre=${seguidos.getNombreUsuario() }">
                                    ${seguidos.getNombreUsuario()}
                                </a>
                            </p>

                        </div>
                        <hr class="text-secondary">
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
</div>