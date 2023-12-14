// Classe de Nivel. 
enum class Nivel { 
    BASICO, 
    INTERMEDIARIO, 
    DIFICIL 
}

// Classe do Aluno, contem o nome do Aluno e uma matricula gerada por função.
data class Aluno(val nomeAluno: String, val numeroMatricula: String){
    override fun toString(): String {
        return "$nomeAluno (matricula $numeroMatricula)"
    }
}
// Classe de Conteudo com o nome do conteudo e a duracao.
data class ConteudoEducacional(val nome: String, val duracao: Int ){
    override fun toString(): String {
        return "$nome (Duração: $duracao)"
    }
}
// Classe de Formacao com o nome, a lista vinculada a classe conteudo e o nivel vinculado a classe de nivel.
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    
	//TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
	// Declaração da variavel inscritos, uma lista originada da classe Aluno.
    val inscritos = mutableListOf<Aluno>()
    
    // Função para alimentar a lista inscritos.
    fun matricular(vararg aluno: Aluno) {
        inscritos.addAll(aluno)
    }

    override fun toString(): String {
        //  retornará -> "Formação: $nome [espaço] Conteúdo educacional: $conteudos [espaço] Nível: $nivel [espaço] Alunos
        // inscritos na formação: $inscritos"
        return """
        Formação: $nome
        Conteúdo educacional: $conteudos 
        Nível: $nivel
        Alunos inscritos na Formação: $inscritos
        """.trimIndent()
    }
}
	// Função que gerará matricula com um número randomico entre 999 e 9999.
     fun gerarMatricula(): String{
         return (999..9999).random().toString()
     }
        
    


fun main() {
    
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    // Declaração dos alunos.
    val leonardo = Aluno("Leonardo", gerarMatricula())
    val henrique = Aluno("Henrique", gerarMatricula())
    val tardim = Aluno("Tardim", gerarMatricula())
    val milani = Aluno("Milani", gerarMatricula())
    
    // Declaração dos conteudos.
    val conteudoKotlin = ConteudoEducacional("Do zero ao avançado em Kotlin", 320)
    val conteudoProjeto = ConteudoEducacional("Entrega de projeto", 120)
    
    val conteudoJava = ConteudoEducacional("Do zero ao avançado em Java", 380)
    val conteudoBackendJava = ConteudoEducacional("Backend com java", 190)
    
    val conteudoPython = ConteudoEducacional("Do zero ao avançado em Python", 200)
    val conteudoBackendPython = ConteudoEducacional("Backend com Python", 190)

    val conteudoPythonPOO = ConteudoEducacional("POO em Python", 80)

    // Declaração das formações.
    val formacaoKotlin = Formacao("Programação em Kotlin", listOf(conteudoKotlin,conteudoProjeto), Nivel.INTERMEDIARIO)
    val formacaoJava = Formacao("Programação em Java", listOf(conteudoJava,conteudoBackendJava), Nivel.DIFICIL)
    val formacaoPython = Formacao("Programação em Python", listOf(conteudoPython,conteudoBackendPython), Nivel.DIFICIL)
    val formacaoPyhtonPoo = Formacao("Programação Orientada a Objetos em Python", listOf(conteudoPythonPOO), Nivel.BASICO)
	
    // Execução da atribuição de matriculas nas formações.
    formacaoKotlin.matricular(leonardo,milani)
    formacaoJava.matricular(leonardo,henrique,tardim,milani)
    formacaoPython.matricular(henrique,tardim)
    formacaoPyhtonPoo.matricular(leonardo,tardim,milani)
    
    //Consultas do resultados das formações.
  	println(formacaoKotlin)
    println("\n----------------------------------------------------------------------------------------------------------------\n")
    println(formacaoJava)
    println("\n----------------------------------------------------------------------------------------------------------------\n")
    println(formacaoPython)
    println("\n----------------------------------------------------------------------------------------------------------------\n")
    println(formacaoPyhtonPoo)
    println("\n----------------------------------------------------------------------------------------------------------------\n")
    
}
