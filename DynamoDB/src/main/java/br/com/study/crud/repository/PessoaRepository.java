package br.com.study.crud.repository;

import br.com.study.crud.entity.Pessoa;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Pessoa save(Pessoa pessoa) {
        dynamoDBMapper.save(pessoa);
        return pessoa;
    }

    public Pessoa getPessoaById(String pessoaId) {
        return dynamoDBMapper.load(Pessoa.class, pessoaId);
    }

    public String delete(String pessoaId) {
        Pessoa emp = dynamoDBMapper.load(Pessoa.class, pessoaId);
        dynamoDBMapper.delete(emp);
        return "Pessoa DELETADA!";
    }

    public String update(String pessoaId, Pessoa pessoa) {
        dynamoDBMapper.save(pessoa,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("pessoaId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(pessoaId)
                                )));
        return pessoaId;
    }
}
