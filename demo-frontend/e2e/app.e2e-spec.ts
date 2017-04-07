import { DemoFrontendPage } from './app.po';

describe('demo-frontend App', () => {
  let page: DemoFrontendPage;

  beforeEach(() => {
    page = new DemoFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
