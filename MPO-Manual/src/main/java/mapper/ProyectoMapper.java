package mapper;

import dto.ProyectoDTO;
import model.Proyecto;

public class ProyectoMapper extends BaseMapper<Proyecto, ProyectoDTO> {


    @Override
    public Proyecto fromDTO(ProyectoDTO item) {
        return Proyecto.builder()
                .idProyecto(item.getId())
                .nombre(item.getNombre())
                .idjefeProyecto(item.getIdJefe())
                .presupuesto(item.getPresupuesto())
                .fechaInicio(item.getFecha_inicio())
                .fechaFin(item.getFecha_fin())
                .build();
    }

    @Override
    public ProyectoDTO toDTO(Proyecto item) {
        return ProyectoDTO.builder()
                .id(item.getIdProyecto())
                .nombre(item.getNombre())
                .idJefe(item.getIdjefeProyecto())
                .presupuesto(item.getPresupuesto())
                .fecha_inicio(item.getFechaInicio())
                .fecha_fin(item.getFechaFin())
                .build();
    }
}
