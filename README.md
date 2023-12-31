# Analises Clinicas

## Requisitos do Sistema do Laboratório

O laboratório deseja que o novo sistema possa fornecer informações rápidas, precisas e seguras a fim de melhorar as suas atividades administrativas e o atendimento aos seus pacientes. Dessa forma, você permanecerá bem menos tempo no laboratório, pois os processos estarão automatizados. Para tanto, o novo sistema deve:

## Cadastro de Pacientes
Permitir o cadastro dos pacientes do laboratório, com todos os dados preenchidos na ficha. Este cadastro será realizado pelas recepcionistas.

## Cadastro de Exames
Permitir o cadastro dos exames que o laboratório pode realizar. Cada exame pertence a um grupo, por exemplo, o exame hemograma pertence ao grupo sangue. Além disso, para cada exame, é preciso saber o seu código, a descrição, o valor e os procedimentos para a sua realização. Por exemplo, para o hemograma, o paciente deve estar em jejum. Esse cadastro será realizado pelos bioquímicos.

## Cadastro de Pedidos de Exames
Permitir o cadastro dos pedidos de exames dos pacientes. É necessário saber os nomes do paciente, do médico que está solicitando os exames e do convênio que o paciente utilizará para esse pedido e, também, o valor dos exames, a data e o horário da realização deles e dos seus resultados. Atenção: cada exame pode ser realizado em datas e horários diferentes. Lembre-se de que o médico pode solicitar mais de um exame em cada pedido (no seu caso, solicitou cinco). Esse cadastro será realizado pelas recepcionistas.

## Emissão de Relatórios
- Emitir a ficha do paciente, a qual contém todos os dados cadastrados. Este relatório será solicitado e recebido tanto pelas recepcionistas quanto pelo departamento administrativo do laboratório.
- Emitir relatório com todos os exames que o laboratório realiza, com o código, a descrição, os procedimentos e o valor de cada um, agrupados por grupo de exame. Devem ser impressos, nesse relatório, o código e a descrição do grupo. O relatório será solicitado e recebido pelas recepcionistas.
- Emitir o pedido do exame em três vias, com todos os dados do pedido do exame. O relatório será emitido pela recepcionista, e a primeira via será entregue ao paciente (comprovante da entrega do exame), a segunda via ao departamento de faturamento (para a cobrança dos exames dos convênios), e a terceira via aos bioquímicos (para a realização dos exames).
- Emitir relatório com os resultados dos exames por pedido, com o nome do paciente, a data e o horário do exame (da sua realização), o nome do médico que solicitou o procedimento, o nome do convênio e o resultado de cada exame realizado caso tenha sido mais de um. O relatório será solicitado pela recepcionista e entregue ao paciente (não é necessário que a recepcionista fique com esse relatório).

# Diagrama UML da Clínica Médica

<p align="center">
  <img src="https://github.com/Adriano1976/Analises-Clinicas/assets/17755195/f29f728c-191d-42a7-9f28-0a0d6bdee6c6" alt="UML-Clinica-Medica">
</p>

 Nesse outro diagrama de classe foi criado uma nova UML, no entanto através da IntelliJ IDE. Isso foi feito depois que o Projeto Análises Clínicas foi refeita e acrescentado algumas funcionalidades e documentações deixando mais robusta e mais clássica. Foi um desafio refatorar o código depois de pronto e assim praticar um pouco mais e compreender cada detalhe da estrutura do projeto como também a importância de conhecer cada etapa, como cada classe, cada métodos e cada atributos de suas respectivas classes e da dependência de uma com a outra.

 ![UML - Clínica Médica](https://github.com/Adriano1976/Analises-Clinicas/assets/17755195/38bec7c4-5ed7-4e64-9056-62edecb97b54)

## Diagrama de Classes do Laboratório de Análises Clínicas

A imagem representa um diagrama de classes para um laboratório de análises clínicas. As classes representadas são:

## Classes

- **Paciente**: Representa os pacientes do laboratório.
- **Médico**: Representa os médicos que solicitam exames.
- **Convenio**: Representa os convênios que os pacientes utilizam.
- **Cidade**: Representa as cidades dos pacientes e médicos.
- **Exame_realizado**: Representa os exames realizados pelos pacientes.
- **UF**: Representa a unidade federativa das cidades.
- **Codigo**: Representa os códigos dos exames realizados.
- **Grupo Exame**: Representa os grupos de exames.

## Relações

As linhas entre as classes representam as relações entre elas. Por exemplo, a classe Paciente está relacionada com a classe Médico através da classe Exame_realizado, indicando que um paciente realiza um exame que é solicitado por um médico.

## Notas

A imagem é rotulada como "Figura 1 - Diagrama de classes do laboratório de análises clínicas / Fonte: os autores" na parte inferior. Isso sugere que o diagrama foi criado pelos autores do documento e representa a estrutura de classes de um sistema para um laboratório de análises clínicas. Como desenvolvedor Java, eu usaria essas classes e relações para modelar o sistema em código, criando classes Java para cada uma delas e usando associações, agregações e composições conforme indicado pelas linhas no diagrama.

## Documentação com Javadoc

O Javadoc é uma ferramenta do JDK (Java Development Kit) que gera documentação de API a partir de comentários presentes no código-fonte. A documentação de API é um dos muitos fatores que contribuem para o sucesso geral de um projeto de software. O Javadoc permite que você extraia comentários de código em arquivos HTML externos, o que ajuda os desenvolvedores a criar facilmente documentação de código. Portanto, caso queira navegar e conhecer a extrutura do projeto, basta usar os recursos disponíveis pelo java doc por meio do link disponibilizado para que você posso já ter uma experiência com o projeto antes mesmo de instalar em sua máquina.

![documentacao-interativa-javadoc-projeto-analises-clinicas](https://github.com/Adriano1976/Analises-Clinicas/assets/17755195/deabdb7a-bffc-4b9a-a09f-7a44ce58761c)

* Link de Acesso: https://adriano1976.github.io/Analises-Clinicas-JavaDoc/index.html

## Dicas para aproveitar ao máximo o Javadoc

Para aproveitar ao máximo o Javadoc, é importante seguir algumas práticas recomendadas. Aqui estão algumas dicas:

- Use comentários Javadoc acima de qualquer classe, método ou campo que você deseja documentar.
- Os comentários Javadoc podem conter tags HTML.
- Os comentários Javadoc são comumente compostos por duas seções: a descrição do que estamos comentando e as tags de bloco independentes (marcadas com o símbolo "@"), que descrevem metadados específicos.
- Use tags de bloco para fornecer informações adicionais, como autor, versão, parâmetros, retorno e outros.
- Documente campos e métodos privados se eles forem importantes para entender o funcionamento interno da classe.

Seguindo essas práticas recomendadas, você pode criar documentação de código clara e útil para seus projetos Java. Isso pode ajudar a tornar seu código mais legível e fácil de manter para você e sua equipe.

Documentação do Projeto com Javadoc - [Análises-Clinicas](https://adriano1976.github.io/Analises-Clinicas-JavaDoc/index.html)

<div align="center">
 <img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=87CEFA&height=120&section=footer"/>**** 
</div>

