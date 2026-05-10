package br.com.voltantes.bd2.streaming_dominio_publico.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.voltantes.bd2.streaming_dominio_publico.TestUtils;
import br.com.voltantes.bd2.streaming_dominio_publico.domain.entities.MidiaEntity;
import jakarta.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class MidiaRepositoryIntegrationTest {
    
    private MidiaRepository underTest;

    @Autowired
    public MidiaRepositoryIntegrationTest(MidiaRepository midiaRepository) {
        this.underTest = midiaRepository;
    }
    
    @Test
    public void testaSefindOneESaveSalvamEResgatamAMidiaCerta() {
        MidiaEntity midiaEntity = TestUtils.criaMidiaEntity1();
        midiaEntity = underTest.save(midiaEntity);
        Optional<MidiaEntity> result = underTest.findById(midiaEntity.getId_midia());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(midiaEntity);
    }

    // @Test
    // public void testaSefindAllResgataAsMidiasCertas() {
    //     MidiaEntity midiaEntity1 = TestUtils.criaMidiaEntity1();
    //     MidiaEntity midiaEntity2 = TestUtils.criaMidiaEntity2();
    //     MidiaEntity midiaEntity3 = TestUtils.criaMidiaEntity3();

    //     MidiaEntity midiaSalva = underTest.save(midiaEntity1);
    //     underTest.save(midiaEntity2);
    //     underTest.save(midiaEntity3);
        
    //     Page<MidiaEntity> result = underTest.findAll(PageRequest.of())

    //     assertThat()
        

    // }


}
