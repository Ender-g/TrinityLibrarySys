public static void setPanleBackgroundImg(
        String imgPath, // 图像路径
        int x, // 组件x坐标
        int y, // 组件y坐标
        int width, // 组件宽度
        int height, // 组件高度
        JLabel Label // 组件所在面板
) {
    if (imgPath == null || imgPath.trim().isEmpty()) {
        System.err.println("Image path is null or empty.");
        return;
    }

    if (Label == null) {
        System.err.println("Label component is null.");
        return;
    }

    try {
        ImageIcon icon = new ImageIcon(imgPath);
        Image img = icon.getImage();

        if (img == null) {
            System.err.println("Failed to load image from path: " + imgPath);
            return;
        }

        img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel imgLabel = new JLabel(icon); // 使用调整后的图标创建标签
        imgLabel.setBounds(x, y, width, height);
        Label.add(imgLabel);
    } catch (Exception e) {
        System.err.println("Error setting panel background image: " + e.getMessage());
        e.printStackTrace();
    }
}