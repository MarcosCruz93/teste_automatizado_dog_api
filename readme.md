# Teste Tecnico - Marcos Cruz QA

Projeto de teste automatizado de api desenvolvido em Java.
- [API utilizada para teste - Dog Ceo](https://dog.ceo/)

## Resumo para execução rápida do projeto
Clonar o repositório em sua máquina local

Para executar apenas os testes usar o seguinte comando `mvn clean test`

Para executar os testes e gerar o relatório HTML utilizar o seguinte comando `mvn clean test site`

O relatório de testes gerado encontra-se no diretorio `target/site/surefire-report.html`

## Versão do Java
java version "1.8.0_451"

Java(TM) SE Runtime Environment (build 1.8.0_451-b10)

Java HotSpot(TM) 64-Bit Server VM (build 25.451-b10, mixed mode)

## Dependencias

As versões das dependencias e plugins utilizados no projeto encontram-se seção PROPERTIES do `pom.xml`

Foi utilizado Junit e rest-assured neste projeto, ambas devems ser adicionadas ao `pom.xml`:

~~~~~~~~
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>${rest-assured.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
~~~~~~~~

Os testes podem ser executados com o seguinte comando `mvn clean test`

## Gerando um report em HTML com informações do projeto e resultados dos testes executados em Junit

Para executar os testes e gerar o relatório HTML utilize o seguinte comando `mvn clean test site`

Para gerar o relatório em HTML os seguintes plugins(maven site, surifire) deve sem adicionados na seção BUILD `pom.xml`

~~~~~~~~
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-site-plugin</artifactId>
                <version>${maven.site.plugin.version}</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>${maven.surefire.plugin.version}</version>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>${maven.compiler.plugin.version}</version>
                <configuration>
                    <source>${maven.compiler.source}</source>
                    <target>${maven.compiler.target}</target>
                </configuration>
            </plugin>
        </plugins>
  </build>
~~~~~~~~

E o surefire report deve ser adicionado na seção de REPORT:

~~~~~~~~
    <reporting>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-report-plugin</artifactId>
                <version>${maven.surefire.report.plugin.version}</version>
            </plugin>
        </plugins>
    </reporting>
~~~~~~~~

O report deverá ser gerado dentro do projeto na seguinte pasta por default : `target/site/index.html`