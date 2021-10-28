package org.serratec.java2backend.exercicio02.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity /* Usa-se quando é uma classe que vai representar uma tabela no BD*/
public class Cliente {
	
	


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) /* método de autoincremento do ID */
		@Column(name = "id_cliente")
		private Long id;
		
		@Column(name = "nome", nullable = false, length = 60)
		private String nome;
		
		@Column(name = "cpf", nullable = false, length = 11)
		private String cpf;
		
		@Column(name = "email", nullable = false, length = 50)
		private String email;
				
		@Column(name = "data_nascimento")
		@Temporal(TemporalType.DATE)
		private LocalDate dataNascimento;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public LocalDate getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		
		

}
