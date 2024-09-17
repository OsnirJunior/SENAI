programa
{
	
	funcao inicio()
	{
		// Definir das variáveis
		cadeia status2
		inteiro n1, n2, n3, status

		// Inicializar variáveis
		status = 0
		status2 = ""

		// Entrada de valores
		escreva("Digite o comprimento da reta 1: ")
		leia(n1)
		escreva("Digite o comprimento da reta 2: ")
		leia(n2)
		escreva("Digite o comprimento da reta 3: ")
		leia(n3)

		// Verificação do maior valor
		se(n1 >= n2 e n1 >= n3){
			status = n1
		}
		se(n2 >= n1 e n2 >= n3){
			status = n2
		}
		se(n3 >= n1 e n3 >= n2){
			status = n3
		}

		// Saída da maior reta
		escreva("\nA maior reta é " + status + ";")
		escreva("\n")

		// Verificação se é possível fazer um triângulo
		se(status < n1 + n2 + n3 - status){
			status2 = ("possível")
		}
		senao{
			status2 = ("impossível")
		}
		// Saída se é possível fazer um triângulo
		escreva("\nE é " + status2 + " fazer um triângulo.\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 823; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */