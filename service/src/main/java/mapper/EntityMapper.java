package mapper;



import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

public interface EntityMapper<D,E> {

        /**
         * Maps a DTO to an entity.
         *
         * @param dto the DTO to map
         * @return the corresponding entity
         */
        E toEntity(D dto);


        /**
         * Maps an entity to a DTO.
         *
         * @param entity the entity to map
         * @return the corresponding DTO
         */
        D toDto(E entity);


        /**
         * Maps a list of DTOs to a list of entities.
         *
         * @param dtoList the list of DTOs to map
         * @return the corresponding list of entities
         */
        List<E> toEntityList(List<D> dtoList);


        /**
         * Maps a list of entities to a list of DTOs.
         *
         * @param entityList the list of entities to map
         * @return the corresponding list of DTOs
         */
        List <D> toDtoList(List<E> entityList);


        /**
         * Updates an existing entity from a DTO.
         *
         * @param dto the DTO containing the updated data
         * @param entity the entity to update
         */
        void updateEntityFromDto(D dto, @MappingTarget E entity);
}
