package br.com.casadocodigo.loja.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

//Adicionado dependencia spring-cloud-aws-context no pom

@Configuration //expor os Beans criados
public class AmazonConfiguration {

	
	//dados do usuario criado pelo IAM
	private static final String ACCESS_KEY="AKIAYYK3N653YKGAFDH3"; 
	private static final String SECRET_KEY="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";
	
	private static final String REGION="us-east-2"; //que o bucket foi criado
	
	
	//método que retorna um obj que ira realizar a implementação de autenticação c/ a aws
	@Bean 
	public BasicAWSCredentials basicAwsCredentials() {
		return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
	}
	
	//método que irá realizar a construção do objeto AmazonS3 para que possamos acessar os serviços S3
	@Bean
	public AmazonS3 amazonS3() {
		return AmazonS3ClientBuilder.standard().withRegion(REGION)
			.withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials())).build();
	}
	
}
