describe("HomePage - YT", () => {
  it("Acesso à página inicial", () => {
    cy.visit("https://youtube.com");
    cy.get(
      "#start > ytd-topbar-logo-renderer.style-scope > #logo > div.style-scope > .ytd-topbar-logo-renderer > #logo-icon",
    ).should("be.visible");
    cy.get(".ytSearchboxComponentInputBox").should("exist");
    cy.get(".ytd-two-column-browse-results-renderer > :nth-child(5)").should(
      "be.visible",
    );
  });

  it("Busca por um vídeo", () => {
    cy.visit("https://youtube.com");
    cy.get(
      "#start > ytd-topbar-logo-renderer.style-scope > #logo > div.style-scope > .ytd-topbar-logo-renderer > #logo-icon",
    ).should("be.visible");
    cy.get(".ytSearchboxComponentInputBox").should("exist");
    cy.get(".ytd-two-column-browse-results-renderer > :nth-child(5)").should(
      "be.visible",
    );

    cy.intercept("POST", "/youtubei/v1/search?prettyPrint=false**").as(
      "postSearch",
    );
    cy.get(".ytSearchboxComponentInputBox").type("Cypress E2E");
    cy.get(".ytSearchboxComponentSearchButton").click();
    cy.wait("@postSearch").its("response.statusCode").should("eq", 200);
    cy.get("ytd-item-section-renderer.style-scope > :nth-child(3)").should(
      "be.visible",
    );
    cy.get("ytd-item-section-renderer.style-scope > :nth-child(3)").contains(
      "Cypress",
    );
  });

  it("Abre um vídeo a partir da busca", () => {
    cy.visit("https://youtube.com");
    cy.get(
      "#start > ytd-topbar-logo-renderer.style-scope > #logo > div.style-scope > .ytd-topbar-logo-renderer > #logo-icon",
    ).should("be.visible");
    cy.get(".ytSearchboxComponentInputBox").should("exist");
    cy.get(".ytd-two-column-browse-results-renderer > :nth-child(5)").should(
      "be.visible",
    );

    cy.intercept("POST", "/youtubei/v1/search?prettyPrint=false**").as(
      "postSearch",
    );
    cy.get(".ytSearchboxComponentInputBox").type("Cypress E2E");
    cy.get(".ytSearchboxComponentSearchButton").click();
    cy.wait("@postSearch").its("response.statusCode").should("eq", 200);
    cy.get("ytd-item-section-renderer.style-scope > :nth-child(3)").should(
      "be.visible",
    );
    cy.get("ytd-item-section-renderer.style-scope > :nth-child(3)").contains(
      "Cypress",
    );

    cy.intercept("GET", "/api/stats/playback?**").as("getVideo");
    cy.get("ytd-thumbnail.style-scope > #thumbnail > yt-image.style-scope > .ytCoreImageHost")
      .eq(1)
      .click();
    // Waiting for ADS
    cy.wait("@getVideo").its("response.statusCode").should("eq", 204);
    cy.get("#movie_player > .html5-video-container > .video-stream").should(
      "be.visible",
    );
    cy.get(
      "#above-the-fold > :nth-child(1) > h1.style-scope > .style-scope",
    ).should("contain.text", "Cypress");
  });
});
