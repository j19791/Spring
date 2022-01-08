package br.com.casadocodigo.loja.infra;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;


//configuração do envio das imagens para o Bucket 
@Component
public class FileSaver {

	@Autowired
	private AmazonS3 amazonS3; //Spring deverá fazer a injeção do objeto AmazonS3 que está sendo gerenciado pelo Spring
	private static final String BUCKET="casadocodigo-jeffersonrm";
	
	public String write(MultipartFile file) {
		try {
			amazonS3.putObject(new PutObjectRequest(BUCKET, 
													file.getOriginalFilename(),
													file.getInputStream(), //fluxo de dados que compõem o arquivo
													null ) //se desejamos colocar metadados de informações
						.withCannedAcl(CannedAccessControlList.PublicRead)); //deixar arquivos do Bucket com visibilidade pública. Qualquer usuário terá permissão de visualizar os arquivos de imagem 
			
			return "http://s3.amazonaws.com" + BUCKET + "/" + file.getOriginalFilename(); //e retornar a URL de acesso ao arquivo
			
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}









