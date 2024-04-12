package program;

import service.ViaCepService;
import service.UsuarioService;
import model.Usuario;
import connection.ConexaoDB;
import dao.Dao;
import java.util.Scanner;
import java.io.IOException;

public class Programa {

	public static void main(String[] args)throws IOException {
		
		Scanner ler = new Scanner(System.in);
		
		Usuario usuario = new Usuario();
		ViaCepService vcs = new ViaCepService();

		int opcao;
		int id = 0;
		
		System.out.printf("---Bem vindo ao cadastro de clientes Salesforce---\n");
		
		System.out.printf("\nPressione 'ENTER' para conectar com servidor ORACLE...");
		System.in.read();
		ConexaoDB.getConnection();
		
		do {
			System.out.printf("\nMENU:\n\n1 - Incluir\n2 - Exibir\n3 - Editar\n4 - Excluir\n5 - Sair\nR:");
			opcao = ler.nextInt();
			
			while((opcao < 1)||(opcao > 5)) {
				System.out.printf("\nErro! Digite uma opção válida!");
				System.out.printf("\n\nMENU:\n\n1 - Incluir\n2 - Exibir\n3 - Editar\n4 - Excluir\n5 - Sair\nR:");
				opcao = ler.nextInt();
			}
			
			if(opcao == 1) {
				
				id++;
				usuario.setId(id);
				
				System.out.printf("\nDigite seu nome: ");
				usuario.setNome(ler.next());
				
				System.out.printf("Digite sua idade: ");
				usuario.setIdade(ler.nextInt());
				
				System.out.printf("Digite seu email: ");
				usuario.setEmail(ler.next());
				
				String consulta;
				System.out.printf("Digite seu CEP: ");
				consulta = ler.next();
					
				try {
					vcs.getEndereco(consulta);
					usuario.setCep(consulta);
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.printf("\nErro ao localizar CEP");
				}
				
				String opcaoDef;
				System.out.printf("O usuário possui deficiência?\n(S) para 'SIM'\n(N) para 'NÃO'\nR:");
				opcaoDef = ler.next().toUpperCase();
				
				while((!opcaoDef.equals("S"))&&(!opcaoDef.equals("N"))) {
					System.out.printf("\nErro! Digite uma resposta válida!");
					System.out.printf("\n\nO usuário possui deficiência?\n(S) para 'SIM'\n(N) para 'NÃO'\nR:");
					opcaoDef = ler.next().toUpperCase();
				}
				
				if(opcaoDef.equals("S")) {
					int opcaoDef2;
					System.out.printf("\nQual a deficiência do usuário?\n(1) Daltonismo\n(2) Baixa visão\nR: ");
					opcaoDef2 = ler.nextInt();
					
					while((opcaoDef2 < 1)||(opcaoDef2 > 2)) {
						System.out.printf("\nErro! Digite uma resposta válida!");
						System.out.printf("\n\nQual a deficiência do usuário?\n\n(1) Daltonismo\n(2) Baixa visão\nR: ");
						opcaoDef2 = ler.nextInt();
					}
					
					if(opcaoDef2 == 1) {
						int opcaoDaltonismo;
						System.out.printf("Qual tipo de Daltonismo:\n\n(1) - Deuteranopia\n(2) - Protanopia\n(3) - Tritanopia\nR:");
						opcaoDaltonismo = ler.nextInt();
						
						while((opcaoDaltonismo<1)||(opcaoDaltonismo>3)) {
							System.out.printf("\nErro! Digite uma opcao válida!");
							System.out.printf("\n\nQual tipo de Daltonismo:\n\n(1) - Deuteranopia\n(2) - Protanopia\n(3) - Tritanopia\nR:");
							opcaoDaltonismo = ler.nextInt();
						}
						
						if(opcaoDaltonismo == 1) {
							usuario.setDeficiencia("Deuteranopia");
							System.out.printf("\nPredefinições do site alteradas para Deuteranopia");
						}
						else if(opcaoDaltonismo == 2) {
							usuario.setDeficiencia("Protanopia");
							System.out.printf("\nPredefinições do site alteradas para Protanopia");
						}
						else {
							usuario.setDeficiencia("Tritanopia");
							System.out.printf("\nPredefinições do site alteradas para Tritanopia");
						}
						
					}else {
						usuario.setDeficiencia("Baixa visão");
						System.out.printf("\nLeitor de tela ativado");
					}
					
				}else {
					usuario.setDeficiencia("Não possui deficiência");
				}
				
				UsuarioService.InserirUsuario(usuario);
				System.out.printf("\nUsuário incluído com sucesso!");
				System.out.printf("\n\n---Aperte 'ENTER' para voltar ao MENU---");
				System.in.read();
			}
			
			else if(opcao == 2) {
				
				int id2; 
				
				System.out.printf("\n");
				UsuarioService.ExibirUsuarios();
				
				System.out.printf("\n\nDigite o ID do usuário que deseja consultar: ");
				id2 = ler.nextInt();
				
				try {
					UsuarioService.ExibirUsuario(id2);
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.printf("\nCliente nao localizado");
				}		
			}
			
			else if(opcao == 3) {
				
				UsuarioService.ExibirUsuarios();
				
				int id2;
				String novo_nome;
				String nova_idade;
				String novo_email;
				String nova_deficiencia;
				String novo_cep;
				String opcao_nova_def;
				
				System.out.printf("Digite o ID do cliente que deseja alterar");
				id2 = ler.nextInt();
				System.out.printf("Digite o novo nome: ");
				novo_nome = ler.next();
				System.out.printf("Digite a nova idade: ");
				nova_idade = ler.next();
				System.out.printf("Digite o novo email: ");
				novo_email = ler.next();
				System.out.printf("Digite o novo CEP: ");
				novo_cep = ler.next();
				System.out.printf("\nO usuário possui deficiência?\n\n(S) para 'SIM'\n(N) para 'NÃO'\nR: ");
				opcao_nova_def = ler.next().toUpperCase();
				
				while((!opcao_nova_def.equals("S")&&(!opcao_nova_def.equals("N")))) {
					System.out.printf("\nErro! Digite um resposta válida!");
					System.out.printf("\nO usuário possui deficiência?\n\n(S) para 'SIM'\n(N) para 'NÃO'\nR: ");
					opcao_nova_def = ler.next().toUpperCase();
				}
				
				if(opcao_nova_def.equals("S")) {
					int opcaoDef2;
					System.out.printf("\nQual a deficiência do usuário?\n(1) Daltonismo\n(2) Baixa visão\nR: ");
					opcaoDef2 = ler.nextInt();
					
					while((opcaoDef2 < 1)||(opcaoDef2 > 2)) {
						System.out.printf("\nErro! Digite uma resposta válida!");
						System.out.printf("\n\nQual a deficiência do usuário?\n\n(1) Daltonismo\n(2) Baixa visão\nR: ");
						opcaoDef2 = ler.nextInt();
					}
					
					if(opcaoDef2 == 1) {
						int opcaoDaltonismo;
						System.out.printf("Qual tipo de Daltonismo:\n\n(1) - Deuteranopia\n(2) - Protanopia\n(3) - Tritanopia\nR:");
						opcaoDaltonismo = ler.nextInt();
						
						while((opcaoDaltonismo<1)||(opcaoDaltonismo>3)) {
							System.out.printf("\nErro! Digite uma opcao válida!");
							System.out.printf("\n\nQual tipo de Daltonismo:\n\n(1) - Deuteranopia\n(2) - Protanopia\n(3) - Tritanopia\nR:");
							opcaoDaltonismo = ler.nextInt();
						}
						
						if(opcaoDaltonismo == 1) {
							nova_deficiencia = "Deuteranopia";
						}
						else if(opcaoDaltonismo == 2) {
							nova_deficiencia = "Protanopia";
						}
						else {
							nova_deficiencia = "Tritanopia";
						}
						
					}else {
						nova_deficiencia = "Baixa visão";
					}
					
				}else {
					nova_deficiencia = "Não possui deficiência";
					
				}
				try {
					String query = String.format("update tb_usuario set nome = '%s', idade = %s, email = '%s', deficiencia = '%s', cep = '%s' where id = %d", novo_nome, nova_idade, novo_email, nova_deficiencia, novo_cep, id2);
			        Dao.InsertUpdateDeleteCommand(query);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.printf("\nID não encontrado!");
				}	
			}
			
			else if(opcao == 4) {
				
				int id2;
				
				UsuarioService.ExibirUsuarios();
				
				System.out.printf("Digite o ID do cliente que deseja excluir: ");
				id2 = ler.nextInt();
				
				try {
					UsuarioService.ExcluirUsuario(id2);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.printf("\nID não encontrado!");
				}	
			}
	
		}while(opcao!=5);
		
		System.out.printf("\nPrograma encerrado!");

		ler.close();	
	}
}