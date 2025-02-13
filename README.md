# Generic Mapper
## 1. Descrição do Problema
Em aplicações que seguem o padrão de arquitetura em camadas (como o SpringBoot), é comum a necessidade de transportar dados entre diferentes camadas, como entre a camada de apresentação (UI) e a camada de serviços ou persistência. Para isso, utilizamos objetos de transferência de dados (DTOs). No entanto, a conversão manual entre DTOs e Models pode levar a código repetitivo, propenso a erros e de difícil manutenção.

## 2. Solução
O **Generic Mapper** é uma solução que centraliza a lógica de conversão entre DTOs e Models em classes dedicadas chamadas mappers. Isso promove a separação de responsabilidades, facilita a manutenção do código e melhora a reusabilidade.

### 2.1. Variações do Mapper Pattern
Para atender diferentes cenários de conversão, o padrão foi dividido em duas variações:

#### **2.1.1. GenericMapperSimple**
Essa variação é uma abordagem básica para conversão entre um Model e um DTO, sem diferenciação entre os tipos de requisição e resposta.

#### Diagrama de Classes

##### Interface Genérica em java
```java
public interface GenericMapperSimple<M, D> {
    M toModel(D dto);
    D toDto(M model);
}
```

#### **2.1.2. GenericMapperVariant**
Essa variação permite uma maior flexibilidade ao lidar com cenários onde o DTO de requisição difere do DTO de resposta.

#### Diagrama de Classes

##### Interface Genérica em java
```java
/**
 * @param <M> Model
 * @param <D> DTO for Request
 * @param <R> DTO for Response
 */
public interface GenericMapperVariant<M, D, R> {
    M toModel(D request);
    R toDto(M model);
}
```

## 4. Exemplos de Uso

### Definição de DTO e Model
```java
public record ProductRequestDto(
        String name,
        double price
) {
}

public class ProductModel {
    private String name;
    private double price;

    public ProductModel(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

```

### Interface Genérica de Mapper
```java
public interface Mapper<D, M> {
    M toModel(D dto);
    D toDTO(M model);
}
```

### Implementação do UserMapper
```java
public class ProductMapper implements GenericMapperVariant<ProductModel, ProductRequestDto, ProductResponseDto>{
    @Override
    public ProductModel toModel(ProductRequestDto dto) {
        return new ProductModel(dto.name(), dto.price());
    }

    @Override
    public ProductResponseDto toDto(ProductModel model) {
        //In this example, the value of the name field is transformed before being returned
        String transformedData = transformData(model.getName());
        return new ProductResponseDto(transformedData, model.getPrice());
    }

    private String transformData(String data) {
        return data.toUpperCase();
    }
}
```
