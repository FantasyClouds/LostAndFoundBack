module.exports = {
  presets: [
    '@vue/cli-plugin-babel/preset',
    '@babel/preset-typescript' // 添加 TypeScript 支持
  ],
  plugins: [
    ['@babel/plugin-transform-class-properties', { loose: true }],
    ['@babel/plugin-transform-private-methods', { loose: true }],
    ['@babel/plugin-transform-private-property-in-object', { loose: true }],
    '@vue/babel-plugin-jsx' // 添加这个插件
  ],
  overrides: [
    {
      include: /node_modules\/pdfjs-dist/,
      presets: ['@babel/preset-env'],
      plugins: [
        ['@babel/plugin-transform-class-properties', { loose: true }],
        ['@babel/plugin-transform-private-methods', { loose: true }],
        ['@babel/plugin-transform-private-property-in-object', { loose: true }]
      ]
    }
  ]
};