package Templates.DesignPattern;

abstract class AbstractClass {
    // 共同的且繁琐的操作
    private void baseOperation() {
        /* TODO */
    }

    // 由子类定制的操作
    protected abstract void customOperation();

    // 模板方法定义的框架
    public final void templateMethod() {
        // 调用基本方法，完成固定逻辑
        baseOperation();
        customOperation();
    }

}

class ConcreteClass1 extends AbstractClass {

    @Override
    protected void customOperation() {
        // 具体模板1 业务逻辑
        System.out.println("具体模板1：customOperation()");
    }
}

class ConcreteClass2 extends AbstractClass {
    @Override
    protected void customOperation() {
        // 具体模板2 业务逻辑
        System.out.println("具体模板2：customOperation()");
    }
}

public class TemplatePattern {
    public static void main(String[] args) {
        AbstractClass abstractClass1 = new ConcreteClass1();
        AbstractClass abstractClass2 = new ConcreteClass2();
        applyTemplate(abstractClass1);
        applyTemplate(abstractClass2);
    }

    public static void applyTemplate(AbstractClass abstractClass) {
        abstractClass.templateMethod();
    }
}
